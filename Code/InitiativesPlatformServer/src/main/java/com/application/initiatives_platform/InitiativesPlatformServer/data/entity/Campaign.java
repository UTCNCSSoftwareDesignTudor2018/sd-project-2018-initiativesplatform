package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "campaign")
public class Campaign extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "start_date")
	@NotNull
	private Date startDate;

	@Column(name = "end_date")
	@NotNull
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
