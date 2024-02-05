package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.UserDAO;
import model.User;

@Controller
@RequestMapping("/")
public class UserController {

	@RequestMapping("/login")
	public String login() {
		return "LoginView";
	}

	@RequestMapping("/signup")
	public String signUp() {
		return "SignUpView";
	}

	@RequestMapping("/logout")
	protected ModelAndView logout(HttpServletRequest request) {
		// clear session
		HttpSession session = request.getSession();
		session.invalidate();
		// redirect to login
		return new ModelAndView("redirect:/login");
	}

	// TODO - ADD RBAC
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request) {
		return "DashboardView";
	}

	@RequestMapping("/settings")
	protected ModelAndView settings(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}

		if ("admin".equals(user.getRole())) {
			return new ModelAndView("ProfileSettingsView");
		}

		return new ModelAndView("ProfileSettingsView");
	}

	@RequestMapping("/processLogin")
	protected ModelAndView processLogin(HttpServletRequest request) {
		// get user by username
		// if exists create session with username, id, role
		// check role
		// if admin go to admin page
		// else user page

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			UserDAO udao = new UserDAO();
			User user = udao.findUserByName(username);

			if (user != null && BCrypt.checkpw(password, user.getPassword())) {
				// user exists and login success
				// create session
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(-1);

				User userWithoutPassword = new User();
				userWithoutPassword.setId(user.getId());
				userWithoutPassword.setUsername(user.getUsername());
				userWithoutPassword.setRole(user.getRole());

				session.setAttribute("user", userWithoutPassword);

				if ("admin".equals(user.getRole())) {
					return new ModelAndView("redirect:/dashboard"); // Redirect to admin page
				} else {
					return new ModelAndView("redirect:/dashboard");
				}
			}

			ModelAndView errorPage = new ModelAndView("redirect:/login");
			errorPage.addObject("error", "Invalid Credentials");
			return errorPage;
		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView errorPage = new ModelAndView("redirect:/login");
			errorPage.addObject("error", "There was an error. Please try again.");
			return errorPage;
		}
	}

	@RequestMapping("/processSignup")
	protected ModelAndView processSignup(@ModelAttribute User user) {
		try {
			UserDAO userDAO = new UserDAO();
			ModelAndView modelLogin = new ModelAndView("redirect:/login");
			ModelAndView modelSignup = new ModelAndView("redirect:/signup");

			// Check if the username already exists
			User existingUser = userDAO.findUserByName(user.getUsername());
			if (existingUser != null) {
				modelSignup.addObject("error", "Username already exists");
				return modelSignup;
			}

			// Save the new user
			int rowAffected = userDAO.add(user);

			if (rowAffected == -1) {
				// User with the same username already exists, handle accordingly
				modelSignup.addObject("error", "Username already exists");
				return modelSignup;
			}

			// Signup successful, redirect to login page
			return modelLogin;
		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("redirect:/signup");
			mv.addObject("error", "There was an error. Please try again.");
			return mv;
		}
	}

	@RequestMapping("/updateProfile")
	protected ModelAndView updateProfile(@ModelAttribute User user, HttpServletRequest request) {
		try {
			UserDAO userDAO = new UserDAO();

			// Check if the user logged in
			HttpSession session = request.getSession();
			User storedUser = (User) session.getAttribute("user");

			if (storedUser == null) {
				return new ModelAndView("redirect:/login");
			}

			// update user
			User foundUser = userDAO.findUserById(storedUser.getId());

			if (foundUser == null) {
				return new ModelAndView("redirect:/logout");
			}

			user.setId(foundUser.getId());

			int updated = userDAO.update(user);

			User userWithoutPassword = new User();
			userWithoutPassword.setId(user.getId());
			userWithoutPassword.setUsername(user.getUsername());
			userWithoutPassword.setRole(user.getRole());

			session.setAttribute("user", userWithoutPassword);

			return new ModelAndView("redirect:/settings");

		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("redirect:/settings");
			mv.addObject("error", "There was an error. Please try again." + e.getMessage());
			return mv;
		}
	}
}
