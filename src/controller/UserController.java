package controller;

import java.util.Base64;
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
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.support.RequestContextUtils;

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

	// TODO - ADD PROPER PAGE ROUTES FOR ADMIN
	@RequestMapping("/dashboard")
	protected ModelAndView dashboard(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		System.out.print(user);

		// not logged in
		if (user == null) {
			redirectAttrs.addFlashAttribute("error", "Login First");
			return new ModelAndView("redirect:/login");
		}

		redirectAttrs.addFlashAttribute(user);

		if ("admin".equals(user.getRole())) {
			return new ModelAndView("DashboardView");
		}

		return new ModelAndView("DashboardView");
	}

	@RequestMapping("/settings")
	protected ModelAndView settings(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// not logged in
			if (user == null) {
				return new ModelAndView("redirect:/login");
			}

			// get user by id
			UserDAO udao = new UserDAO();
			User foundUser = udao.findUserById(user.getId());

			if ("admin".equals(user.getRole())) {
				return new ModelAndView("ProfileSettingsView").addObject("initUser", foundUser);
			}

			return new ModelAndView("ProfileSettingsView").addObject("initUser", foundUser);
		} catch (Exception e) {
			e.printStackTrace();

			return new ModelAndView("ProfileSettingsView").addObject("error", "There was an error. Please try again.");
		}
	}

	@RequestMapping("/processLogin")
	protected ModelAndView processLogin(HttpServletRequest request, RedirectAttributes redirectAttrs) {
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
				userWithoutPassword.setProfileImage(user.getProfileImage());

				// encode image to base64
//				userWithoutPassword.setProfileImage(encodedProfileImage);

				session.setAttribute("user", userWithoutPassword);
				redirectAttrs.addFlashAttribute("user", userWithoutPassword);
				if ("admin".equals(user.getRole())) {
					return new ModelAndView("redirect:/dashboard"); // Redirect to admin page
				} else {
					return new ModelAndView("redirect:/dashboard");
				}
			}

			ModelAndView errorPage = new ModelAndView("redirect:/login");
			redirectAttrs.addFlashAttribute("error", "Invalid Credentials");
			return errorPage;
		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();

			redirectAttrs.addFlashAttribute("error", "There was an error. Please try again.");

			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("/processSignup")
	protected ModelAndView processSignup(@ModelAttribute User user, RedirectAttributes redirectAttrs) {
		try {
			UserDAO userDAO = new UserDAO();
			ModelAndView modelLogin = new ModelAndView("redirect:/login");
			ModelAndView modelSignup = new ModelAndView("redirect:/signup");

			// Check if the username already exists
			User existingUser = userDAO.findUserByName(user.getUsername());
			if (existingUser != null) {
				redirectAttrs.addFlashAttribute("error", "Username already exists");
				return modelSignup;
			}

			// Save the new user
			int rowAffected = userDAO.add(user);

			// Signup successful, redirect to login page
			return modelLogin;
		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("redirect:/signup");
			redirectAttrs.addFlashAttribute("error", "There was an error. Please try again.");
			return mv;
		}
	}

	@RequestMapping("/updateProfile")
	protected ModelAndView updateProfile(@ModelAttribute User user, HttpServletRequest request,
			RedirectAttributes redirectAttrs) {
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
			System.out.print(updated);

			User userWithoutPassword = new User();
			userWithoutPassword.setId(user.getId());
			userWithoutPassword.setUsername(user.getUsername());
			userWithoutPassword.setRole(storedUser.getRole());

			session.setAttribute("user", userWithoutPassword);

			return new ModelAndView("redirect:/settings");

		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("redirect:/settings");
			redirectAttrs.addFlashAttribute("error", "There was an error. Please try again." + e.getMessage());
			return mv;
		}
	}
}
