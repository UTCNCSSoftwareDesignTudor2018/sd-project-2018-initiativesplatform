package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired private ProjectRepository projectRepository;
	@Autowired private UserService userService;
	@Autowired private CategoryService categoryService;
	
	public void save(String name, String shortDescription, String description, byte[] photo, String proponentUserName, String categoryName) {
		
		User user = userService.getUser(proponentUserName);
		Category category = categoryService.getCategory(categoryName);
		Project project = new Project(name, shortDescription, description, photo, user, category);
		
		projectRepository.save(project);
	
	}
	
	public List<Project> findAll() {
		
		List<Project> projects = projectRepository.findAll();
		
		return projects;
	
	}
	
	public List<Project> findAllByProponentUserName(String userName) {
		
		List<Project> projectsOfProponent = projectRepository.findAllByProponentAccountInfoUserName(userName);
	
		return projectsOfProponent;
		
	}

}
