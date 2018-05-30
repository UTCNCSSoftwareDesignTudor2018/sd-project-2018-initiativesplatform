package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "_user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

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

	public String getUserType() {
		return this.getAccountInfo().getUserType();
	}

	public void setUserType(String userType) {
		this.getAccountInfo().setUserType(userType);
	}

	public String getFirstName() {
		return this.getPersonalInfo().getFirstName();
	}

	public void setFirstName(String firstName) {
		this.getPersonalInfo().setFirstName(firstName);
	}

	public String getLastName() {
		return this.getPersonalInfo().getLastName();
	}

	public void setLastName(String lastName) {
		this.getPersonalInfo().setLastName(lastName);
	}

	public String getIdNumber() {
		return this.getPersonalInfo().getIdNumber();
	}

	public void setIdNumber(String idNumber) {
		this.getPersonalInfo().setIdNumber(idNumber);
	}

	public String getEmail() {
		return this.getPersonalInfo().getEmail();
	}

	public void setEmail(String email) {
		this.getPersonalInfo().setEmail(email);
	}

	public String getPhone() {
		return this.getPersonalInfo().getPhone();
	}

	public void setPhone(String phone) {
		this.getPersonalInfo().setPhone(phone);
	}

	public String getAddress() {
		return this.getPersonalInfo().getAddress();
	}

	public void setAddress(String address) {
		this.personalInfo.setAddress(address);
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
