package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "short_description", columnDefinition = "text")
	@NotNull
	private String shortDescription;

	@Column(name = "description", columnDefinition = "text")
	@NotNull
	private String description;

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proponent_id")
	private User proponent;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "project_id")
	private List<Comment> comments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	public Project() {
		super();
	}

	public Project(@NotNull String name,
			@NotNull String shortDescription, @NotNull String description, @NotNull String photo, User proponent,
			Category category) {
		
		super(new Date(Calendar.getInstance().getTime().getTime()));
		
		this.name = name;
		this.shortDescription = shortDescription;
		this.description = description;
		this.photo = photo.getBytes();
		this.proponent = proponent;
		this.comments = new ArrayList<Comment>();
		this.category = category;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return new String(photo);
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public User getProponent() {
		return proponent;
	}

	public void setProponent(User proponent) {
		this.proponent = proponent;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
