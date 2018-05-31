package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.ProjectDto;

public interface ProjectService {
	public void save(String name, String shortDescription, String description, String photo, String proponentUserName,
			String categoryName);

	public List<Project> findAll();

	public List<Category> findAllCategories();

	public List<Project> findAllByProponentUserName(String userName);

	public Page<Project> getProjectsFromPage(int pageNumber);
	
	public Project getProjectByName(String name);

	public List<ProjectDto> getProjectsForList(int pageNumber);

	public ProjectDto getProjectForList(String projectName);

	public Project findByName(String selectedProjectName);

	public void voteProject(String selectedProjectName, String loggedInUserName);

	public void addToFavorites(String selectedProjectName, String loggedInUserName);

	public void comment(String projectName, String loggedInUserName, String commentText);

	public void removeFavorites(String selectedProjectName, String loggedInUserName);
}
