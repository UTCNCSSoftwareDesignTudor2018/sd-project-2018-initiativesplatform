package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Long version;
	
	@Column(name = "time_stamp")
	@NotNull
	private Date timeStamp;
	
	public BaseEntity() {
		super();
	}
	
	public BaseEntity(Long id, Long version, @NotNull Date timeStamp) {
		super();
		this.id = id;
		this.version = version;
		this.timeStamp = timeStamp;
	}
	
	public BaseEntity(@NotNull Date timeStamp) {
		super();
		this.timeStamp = timeStamp;
	}
	
	@SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 205, allocationSize = 12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
