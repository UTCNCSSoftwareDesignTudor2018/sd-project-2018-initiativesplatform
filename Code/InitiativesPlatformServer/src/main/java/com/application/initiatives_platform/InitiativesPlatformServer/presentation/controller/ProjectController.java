package com.application.initiatives_platform.InitiativesPlatformServer.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.application.initiatives_platform.InitiativesPlatformServer.business.services.ProjectService;
import com.application.initiatives_platform.InitiativesPlatformServer.business.services.SecurityService;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired SecurityService securityService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getProjects() {

		List<Project> projects = projectService.findAll();

		ModelAndView mv = new ModelAndView("projects");

		mv.addObject("projects", projects);

		return mv;

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addProject() {

		List<Category> categories = projectService.findAllCategories();

		ModelAndView mv = new ModelAndView("propose-project");

		mv.addObject("categories", categories);

		return mv;
	}

	@RequestMapping(value = "/propose", method = RequestMethod.POST)
	public ModelAndView proposeProject(HttpServletRequest request) {

		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortDescription");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String photo = request.getParameter("image");
		
		String proponentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		projectService.save(name, shortDescription, description, photo, proponentUserName, category);

		ModelAndView mv = new ModelAndView("propose-project");
		List<Category> categories = projectService.findAllCategories();
		mv.addObject("categories", categories);

		return mv;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public ModelAndView selectProject(HttpServletRequest request) {

		String selectedProjectName = request.getParameter("name");

		Project selectedProject = projectService.findByName(selectedProjectName);

		ModelAndView mv = new ModelAndView("project-detail");

		mv.addObject("project", selectedProject);

		return mv;
	}
	
	@RequestMapping(value = "/vote", method = RequestMethod.POST)
	public RedirectView voteProject(HttpServletRequest request) {
		
		String selectedProjectName = request.getParameter("projectName");
		
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		projectService.voteProject(selectedProjectName, loggedInUserName);
		
		return new RedirectView("/");
	}
	
	@RequestMapping(value = "/favorites/add", method = RequestMethod.POST)
	public RedirectView addToFavorites(HttpServletRequest request) {
		
		String selectedProjectName = request.getParameter("projectName");
		
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		projectService.addToFavorites(selectedProjectName, loggedInUserName);
		
		return new RedirectView("/");
	}
	
	@RequestMapping(value = "/favorites/remove", method = RequestMethod.POST)
	public RedirectView removeFavorites(HttpServletRequest request) {
		
		String selectedProjectName = request.getParameter("projectName");
		
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		projectService.removeFavorites(selectedProjectName, loggedInUserName);
		
		return new RedirectView("/favorites");
	}
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public RedirectView comment(HttpServletRequest request) {
		
		String commentText = request.getParameter("commentText");
		
		String projectName = request.getParameter("projectName");
		
		String loggedInUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		projectService.comment(projectName, loggedInUserName, commentText);
		
		return new RedirectView("/projects/select?name=" + projectName);
		
	}
}
