package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.ProjectRepository;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	// @Autowired private UserServiceImpl userService;
	@Autowired
	private CategoryService categoryService;
	/// Only for tests
	@Autowired
	private UserRepository userRepository;

	public void save(String name, String shortDescription, String description, byte[] photo, String proponentUserName,
			String categoryName) {

		User user = userRepository.findByAccountInfoUserName(proponentUserName);
		Category category = categoryService.getCategory(categoryName);
		Project project = new Project(name, shortDescription, description, photo, user, category);

		projectRepository.save(project);

	}

	public List<Project> findAll() {

		List<Project> projects = projectRepository.findAll();

		return projects;

	}

	public List<Category> findAllCategories() {

		List<Category> categories = categoryService.findAll();

		return categories;

	}

	public List<Project> findAllByProponentUserName(String userName) {

		List<Project> projectsOfProponent = projectRepository.findAllByProponentAccountInfoUserName(userName);

		return projectsOfProponent;

	}

	public Page<Project> getProjectsFromPage(int pageNumber) {
		PageRequest pageRequest = PageRequest.of(pageNumber - 1, 10, Sort.Direction.ASC, "id");
		return this.projectRepository.findAll(pageRequest);
	}
}
