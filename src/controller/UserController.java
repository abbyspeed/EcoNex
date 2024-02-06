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

	@RequestMapping("/Login")
	public String login() {
		return "LoginView";
	}

	@RequestMapping("/Signup")
	public String signUp() {
		return "SignUpView";
	}

	@RequestMapping("/Logout")
	protected ModelAndView logout(HttpServletRequest request) {
		// clear session
		HttpSession session = request.getSession();
		session.invalidate();
		// redirect to login
		return new ModelAndView("redirect:/Login");
	}

	// TODO - ADD PROPER PAGE ROUTES FOR ADMIN
	@RequestMapping("/Dashboard")
	protected ModelAndView dashboard(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
		if (user == null) {
			redirectAttrs.addFlashAttribute("error", "Login First");
			return new ModelAndView("redirect:/Login");
		}

		redirectAttrs.addFlashAttribute(user);

		if ("admin".equals(user.getRole())) {
			return new ModelAndView("redirect:/Admin/Dashboard");
		}

		return new ModelAndView("DashboardView");
	}

	@RequestMapping("/Settings")
	protected ModelAndView settings(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// not logged in
			if (user == null) {
				return new ModelAndView("redirect:/Login");
			}

			// get user by id
			UserDAO udao = new UserDAO();
			User foundUser = udao.findUserByName(user.getUsername());

			if ("admin".equals(user.getRole())) {
				return new ModelAndView("AdminProfileSettingsView").addObject("initUser", foundUser);
			}

			return new ModelAndView("ProfileSettingsView").addObject("initUser", foundUser);
		} catch (Exception e) {
			e.printStackTrace();

			return new ModelAndView("ProfileSettingsView").addObject("error", "There was an error. Please try again.");
		}
	}

	@RequestMapping("/ProcessLogin")
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
				userWithoutPassword.setUserid(user.getUserid());
				userWithoutPassword.setUsername(user.getUsername());
				userWithoutPassword.setRole(user.getRole());

				// encode image to base64
//				userWithoutPassword.setProfileImage(encodedProfileImage);

				session.setAttribute("user", userWithoutPassword);
				redirectAttrs.addFlashAttribute("user", userWithoutPassword);
				if ("admin".equals(user.getRole())) {
					return new ModelAndView("redirect:/Admin/Dashboard"); // Redirect to admin page
				} else {
					return new ModelAndView("redirect:/Dashboard");
				}
			}

			ModelAndView errorPage = new ModelAndView("redirect:/Login");
			redirectAttrs.addFlashAttribute("error", "Invalid Credentials");
			return errorPage;
		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();

			redirectAttrs.addFlashAttribute("error", "There was an error. Please try again.");

			return new ModelAndView("redirect:/Login");
		}
	}

	@RequestMapping("/ProcessSignup")
	protected ModelAndView processSignup(@ModelAttribute User user, RedirectAttributes redirectAttrs) {
		try {
			UserDAO userDAO = new UserDAO();
			ModelAndView modelLogin = new ModelAndView("redirect:/Login");
			ModelAndView modelSignup = new ModelAndView("redirect:/Signup");

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
			ModelAndView mv = new ModelAndView("redirect:/Signup");
			redirectAttrs.addFlashAttribute("error", "There was an error. Please try again.");
			return mv;
		}
	}

	@RequestMapping("/UpdateProfile")
	protected ModelAndView updateProfile(@ModelAttribute User user, HttpServletRequest request,
			RedirectAttributes redirectAttrs) {
		try {
			UserDAO userDAO = new UserDAO();

			// Check if the user logged in
			HttpSession session = request.getSession();
			User storedUser = (User) session.getAttribute("user");

			if (storedUser == null) {
				return new ModelAndView("redirect:/Login");
			}

			// update user
			User foundUser = userDAO.findUserByName(storedUser.getUsername());

			if (foundUser == null) {
				return new ModelAndView("redirect:/Logout");
			}

			user.setUserid(foundUser.getUserid());

			int updated = userDAO.update(user);
			System.out.print(updated);

			User userWithoutPassword = new User();
			userWithoutPassword.setUserid(user.getUserid());
			userWithoutPassword.setUsername(user.getUsername());
			userWithoutPassword.setRole(storedUser.getRole());

			session.setAttribute("user", userWithoutPassword);

			return new ModelAndView("redirect:/Settings");

		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("redirect:/Settings");
			redirectAttrs.addFlashAttribute("error", "There was an error. Please try again." + e.getMessage());
			return mv;
		}
	}

	@RequestMapping("/DeleteAccount")
	protected ModelAndView deleteAccount(HttpServletRequest request) {
		try {
			UserDAO userDAO = new UserDAO();
			ModelAndView modelLogin = new ModelAndView("redirect:/Login");

			// check if logged in
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// if so, then get user by id from session
			if (user == null) {
				return modelLogin;
			}

			User foundUser = userDAO.findUserByName(user.getUsername());

			// delete user
			userDAO.delete(foundUser.getUsername());
			session.invalidate();

			// redirect to login page
			return modelLogin;
		} catch (Exception e) {
			// Handle other exceptions (log the error, redirect to an error page, etc.)
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("redirect:/Login");
			return mv;
		}
	}
}