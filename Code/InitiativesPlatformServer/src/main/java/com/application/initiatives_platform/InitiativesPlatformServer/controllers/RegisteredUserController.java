package com.application.initiatives_platform.InitiativesPlatformServer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.initiatives_platform.InitiativesPlatformServer.business.services.ProjectService;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Favorites;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

@Controller
@RequestMapping(value = "/registered-user")
public class RegisteredUserController {
	
	@Autowired ProjectService projectService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody public ResponseEntity<Boolean> login(HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		
	}
	
	@RequestMapping(value = "/project/propose", method = RequestMethod.POST)
	public void proposeProject(HttpServletRequest request) {

		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortDescription");
		String description = request.getParameter("description");
		byte[] photo = null;
		String proponentUserName = request.getParameter("proponentUserName");
		String categoryName = request.getParameter("categoryName");
	
		projectService.save(name, shortDescription, description, photo, proponentUserName, categoryName);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView viewAllProjects() {
		System.err.println("viewAllProjects()");
		List<Project> projects = projectService.findAll();
		
		ModelAndView mv = new ModelAndView("projects");
		
		mv.addObject("name", "Robert");
		
		mv.addObject("projects", projects);
		
		return mv;
	}
	
	@RequestMapping(value = "/projects/view-proposed-projects", method = RequestMethod.POST)
	public ModelAndView getProjects(HttpServletRequest request) {
		
		String proponentUserName = request.getParameter("proponentUserName");
		
		List<Project> projects = projectService.findAllByProponentUserName(proponentUserName);
		
		ModelAndView mv = new ModelAndView("proposed-projects");
		
		mv.addObject("projects", projects);
		
		return mv;
	
	}
	
	@RequestMapping(value = "/projects/view-voted-projects", method = RequestMethod.POST)
	public ModelAndView getVotedProjects(HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/project/add-to-favorites", method = RequestMethod.POST)
	public void addToFavorites(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/project/remove-from-favorites", method = RequestMethod.POST)
	public void removeFromFavorites(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/comment/report", method = RequestMethod.POST)
	public void reportComment(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/project/report", method = RequestMethod.POST)
	public void reportProject(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/favorites/", method = RequestMethod.POST)
	@ResponseBody public ResponseEntity<List<Favorites>> getFavorites(HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/project/vote", method = RequestMethod.POST)
	public void voteProject(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/project/comment", method = RequestMethod.POST)
	public void commentProject(HttpServletRequest request) {
		
	}
}
