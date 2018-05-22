package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "short_description", columnDefinition = "text")
	@NotNull
	private String shortDescription;

	@Column(name = "code")
	@NotNull
	private String code;

	public Category() {}
	
	public Category(@NotNull String name,
			@NotNull String shortDescription, @NotNull String code) {
		super(new Date(Calendar.getInstance().getTime().getTime()));
		this.name = name;
		this.shortDescription = shortDescription;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
