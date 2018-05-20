package com.application.initiatives_platform.InitiativesPlatformServer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.initiatives_platform.InitiativesPlatformServer.business.services.CategoryService;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired CategoryService categoryService;
	
	@RequestMapping(value = "/content-supervisors/remove", method = RequestMethod.POST)
	public void removeContentSupervisor(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/content-supervisors/update", method = RequestMethod.POST)
	public void updateContentSupervisor(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/content-supervisors/add", method = RequestMethod.POST)
	public void addContentSupervisor(HttpServletRequest request) {
		
	}
	
	@RequestMapping(value = "/categories/", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = categoryService.findAll();
		return ResponseEntity.ok(categories);
	}
	
	@RequestMapping(value = "/categories/add")
	public void addCategory(HttpServletRequest request) {
		String name = request.getParameter("name");
		String shortDescription = request.getParameter("shortDescription");
		categoryService.save(name, shortDescription);
	}
	
}
