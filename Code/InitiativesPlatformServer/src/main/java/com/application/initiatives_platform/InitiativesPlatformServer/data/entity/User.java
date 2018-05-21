package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "_user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Embedded
	private PersonalInfo personalInfo;

	@Embedded
	private AccountInfo accountInfo;

	@Column
	@ElementCollection(targetClass=Role.class)
	private Set<Role> roles;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

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

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<Favorites> getFavoriteProjects() {
		return favoriteProjects;
	}

	public void setFavoriteProjects(List<Favorites> favoriteProjects) {
		this.favoriteProjects = favoriteProjects;
	}

	public String getUserName() {
		return this.getAccountInfo().getUserName();
	}

	public void setUserName(String userName) {
		this.getAccountInfo().setUserName(userName);
	}

	public String getPassword() {
		return this.getAccountInfo().getPassword();
	}

	public void setPassword(String password) {
		this.getAccountInfo().setPassword(password);
	}
}
