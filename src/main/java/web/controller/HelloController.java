package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.Model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	private UserServiceImpl userServiceImpl;
  @Autowired
	public HelloController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@GetMapping("/")
	public String allUsers(Model model) {
		List<User> users = userServiceImpl.allUsers();
		model.addAttribute("usersList", users);
		return "users";
	}

	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") int id, Model model) {
		User user = userServiceImpl.getById(id);
		model.addAttribute("user", user);
		return "editPage";
	}

	@PostMapping("/edit")
	public String editUser(@ModelAttribute("user") User user) {
		userServiceImpl.edit(user);
		return "redirect:/";
	}
	@GetMapping(value = "/add")
	public String addPage(@ModelAttribute("user") User user) {
		return"new";
	}
	@PostMapping(value = "/add")
	public String addUser(@ModelAttribute("user") User user) {
		userServiceImpl.add(user);
		return "redirect:/";
	}

	@GetMapping(value="/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		User user = userServiceImpl.getById(id);
		userServiceImpl.delete(user);
		return "redirect:/";
	}

}