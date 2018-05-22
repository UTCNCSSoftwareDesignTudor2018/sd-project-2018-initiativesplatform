package com.application.initiatives_platform.InitiativesPlatformServer.data.dto;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;

public class ProjectDTO {
	private String name;
	private String shortDescription;
	private String proponentFullName;
	
	public ProjectDTO(Project project) {
		this.name = project.getName();
		this.shortDescription = project.getShortDescription();
	}
}
