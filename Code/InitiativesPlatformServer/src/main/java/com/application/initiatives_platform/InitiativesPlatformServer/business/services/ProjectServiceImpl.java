package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Campaign;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Category;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Comment;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.ProjectRepository;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.ProjectDto;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired private ProjectRepository projectRepository;
	@Autowired private UserService userService;
	@Autowired private CategoryService categoryService;
	@Autowired private VoteService voteService;
	@Autowired private CampaignService campaignService;
	@Autowired private FavoritesService favoritesService;
	@Autowired private CommentService commentService;

	public void save(String name, String shortDescription, String description, String photo, String proponentUserName,
			String categoryName) {

		User user = userService.getUser(proponentUserName);
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
	
	public Project getProjectByName(String name) {
		return this.projectRepository.findByName(name);
	}

	public List<ProjectDto> getProjectsForList(int pageNumber) {
		List<Project> projects = getProjectsFromPage(pageNumber).getContent();
		List<ProjectDto> projectsForList = projects.stream().map(p -> new ProjectDto(p)).collect(Collectors.toList());
		return projectsForList;
	}

	public ProjectDto getProjectForList(String projectName) {
		return new ProjectDto(this.findByName(projectName));
	}

	public Project findByName(String selectedProjectName) {
		Project project = projectRepository.findByName(selectedProjectName);
		return project;
	}

	public void voteProject(String selectedProjectName, String loggedInUserName) {
		
		Project selectedProject = projectRepository.findByName(selectedProjectName);
		User user = userService.getUser(loggedInUserName);
		Campaign campaign = campaignService.getCurrentCampaign();
		
		voteService.save(selectedProject, user, campaign);
		
	}

	public void addToFavorites(String selectedProjectName, String loggedInUserName) {
		Project selectedProject = projectRepository.findByName(selectedProjectName);
		User user = userService.getUser(loggedInUserName);
		
		favoritesService.save(selectedProject, user);
	}

	@Override
	public void comment(String projectName, String loggedInUserName, String commentText) {
		
		Project project = projectRepository.findByName(projectName);
		User user = userService.getUser(loggedInUserName);
		
		Comment comment = commentService.save(project, user, commentText);
		
		project.getComments().add(comment);
		
		projectRepository.save(project);
	}

	@Override
	public void removeFavorites(String selectedProjectName, String loggedInUserName) {
		Project project = projectRepository.findByName(selectedProjectName);
		User user = userService.getUser(loggedInUserName);
		
		favoritesService.remove(project, user);
		
	}
}
