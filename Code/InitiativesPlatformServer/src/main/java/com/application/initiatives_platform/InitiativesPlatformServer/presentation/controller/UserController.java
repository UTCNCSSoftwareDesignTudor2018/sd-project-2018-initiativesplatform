package com.application.initiatives_platform.InitiativesPlatformServer.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.application.initiatives_platform.InitiativesPlatformServer.business.services.ProjectService;
import com.application.initiatives_platform.InitiativesPlatformServer.business.services.SecurityService;
import com.application.initiatives_platform.InitiativesPlatformServer.business.services.UserServiceImpl;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.ProjectDto;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.UserDto;

@Controller
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private ProjectService projectService;
	
	@GetMapping(value = "")
	public ModelAndView home(HttpServletRequest request, HttpSession session) {
		User loggedInUser = this.userService.getUser(this.securityService.findLoggedInUsername());
		List<ProjectDto> projects = projectService.getProjectsForList(1);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("loggedInUser", loggedInUser);
		mv.addObject("projects", projects);
		return mv;
	}

	@GetMapping(value = "register")
	public ModelAndView register() {
		UserDto userDto = new UserDto();
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("user", userDto);
		return mv;
	}

	@PostMapping(value = "register")
	@ResponseBody
	public RedirectView registerLogic(@Valid UserDto userDto, HttpServletRequest request) {
		User registeredUser = userService.registerUser(userDto);
		if (registeredUser != null) {
			securityService.autologin(userDto.getUserName(), userDto.getPassword());
			return new RedirectView("login");
		} else {
			return new RedirectView("registration-failed-page");
		}
	}
	
	@GetMapping(value = "login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping(value = "login")
	@ResponseBody
	public RedirectView loginLogic(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		this.securityService.autologin(username, password);
		if (this.userDetailsService.loadUserByUsername(username) != null) {
			return new RedirectView("/");
		}
		return null;
	}
	
	@GetMapping(value = "logout")
	public RedirectView logout() {
		this.securityService.logout();
		return new RedirectView("/");
	}
	
	@GetMapping(value = "editProfile")
	public ModelAndView editProfile() {
		User loggedInUser = this.userService.getUser(this.securityService.findLoggedInUsername());
		String userName = this.securityService.findLoggedInUsername();
		UserDto userDto = this.userService.getUserDto(userName);
		ModelAndView mv = new ModelAndView("edit-profile");
		mv.addObject("loggedInUser", loggedInUser);
		mv.addObject("user", userDto);
		return mv;
	}
	
	@PostMapping(value = "editProfile")
	public RedirectView editProfileLogic(@Valid UserDto userDto, HttpServletRequest request) {
		this.userService.editProfile(userDto);
		return new RedirectView("/");
	}
	
	@GetMapping(value = "favorites")
	public ModelAndView favoriteProjects(HttpServletRequest request) {
		User loggedInUser = this.userService.getUser(this.securityService.findLoggedInUsername());
		List<ProjectDto> projects = this.userService.getFavoriteProjects(this.securityService.findLoggedInUsername());
		ModelAndView mv = new ModelAndView("favorite-projects");
		mv.addObject("loggedInUser", loggedInUser);
		mv.addObject("projects", projects);
		return mv;
	}
	
	@GetMapping(value = "proposedProjects")
	public ModelAndView getProposedProjects() {
	
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<ProjectDto> proposedProjects = userService.getProposedProjects(loggedInUserName);
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("projects", proposedProjects);
		
		return mv;
	}
	
	@GetMapping(value = "votedProjects")
	public ModelAndView getVotedProjects() {
	
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<ProjectDto> proposedProjects = userService.getVotedProjects(loggedInUserName);
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("projects", proposedProjects);
		
		return mv;
	}
	
	@GetMapping(value = "favoriteProjects")
	public ModelAndView getFavoriteProjects() {
	
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<ProjectDto> proposedProjects = userService.getFavoriteProjects(loggedInUserName);
		
		ModelAndView mv = new ModelAndView("favorites");
		
		mv.addObject("projects", proposedProjects);
		
		return mv;
	}
}
