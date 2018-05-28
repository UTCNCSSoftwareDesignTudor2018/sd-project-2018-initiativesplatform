package com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

public class ProjectDto {

	private String name;
	private String shortDescription;
	private String description;
	private String category;
	private String proponentFullName;
	private String photo;

	public ProjectDto(Project project) {
		this.name = project.getName();
		this.shortDescription = project.getShortDescription();
		this.description = project.getDescription();
		this.category = project.getCategory().getName();
		this.proponentFullName = project.getProponent().getFirstName() + " " + project.getProponent().getLastName();
		if (project.getPhoto() != null) {
			this.photo = new String(project.getPhoto());
		} else {
			this.photo = "";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProponentFullName() {
		return proponentFullName;
	}

	public void setProponentFullName(String proponentFullName) {
		this.proponentFullName = proponentFullName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
