package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Embedded
	private PersonalInfo personalInfo;

	@Embedded
	private AccountInfo accountInfo;

	public User() {
		super();
	}

	public User(PersonalInfo personalInfo, AccountInfo accountInfo) {
		super();
		this.personalInfo = personalInfo;
		this.accountInfo = accountInfo;
	}

	@OneToMany(mappedBy = "proponent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Project> proposedProjects;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Favorites> favoriteProjects;

	public List<Project> getProposedProjects() {
		return proposedProjects;
	}

	public void setProposedProjects(List<Project> proposedProjects) {
		this.proposedProjects = proposedProjects;
	}
}
