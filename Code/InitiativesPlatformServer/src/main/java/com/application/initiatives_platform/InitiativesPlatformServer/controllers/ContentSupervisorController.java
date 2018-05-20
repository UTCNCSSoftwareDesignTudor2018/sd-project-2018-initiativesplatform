package com.application.initiatives_platform.InitiativesPlatformServer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Comment;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

@Controller
@RequestMapping(value = "/content-supervisor")
public class ContentSupervisorController {
	@RequestMapping(value = "/project/remove", method = RequestMethod.POST)
	public void removeProject(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/user/restrict", method = RequestMethod.POST)
	public void restrictUser(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/user/block", method = RequestMethod.POST)
	public void blockUser(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/projects/view-reported", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity<List<Project>> viewReportedProjects() {
		return null;
	}
	
	@RequestMapping(value = "/comments/view-reported", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity<List<Comment>> viewReportedComments() {
		return null;
	}
	
	@RequestMapping(value = "/comment/remove", method = RequestMethod.POST)
	public void removeComment(HttpServletRequest request) {
		
	}
}
