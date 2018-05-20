package com.application.initiatives_platform.InitiativesPlatformServer.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.initiatives_platform.InitiativesPlatformServer.business.services.ProjectService;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Vote;

@Controller
@RequestMapping(value = "/")
public class UnregisteredUserController {
	
	@Autowired ProjectService projectService;
	
	@GetMapping(value = "register")
	ModelAndView register() {
		ModelAndView mv = new ModelAndView("register-page");
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity<List<Project>> getProjects() {
		
		List<Project> projects = projectService.findAll();
		
		return ResponseEntity.ok(projects);
	}
	
	@RequestMapping(value = "/view-project", method = RequestMethod.POST)
	@ResponseBody public ResponseEntity<Project> getProject(HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public void createAccount(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/view-vote-results", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity<Map<Project, List<Vote>>> getVotingResults() {
		return null;
	}
	
}
