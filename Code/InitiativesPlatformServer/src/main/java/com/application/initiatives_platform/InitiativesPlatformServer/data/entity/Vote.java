package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class Vote extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voted_project_id")
	private Project votedProject;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voting_user_id")
	private User votingUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;

	public Vote() {}
	
	public Vote(Project project, User user, Campaign campaign) {
		super(new Date(Calendar.getInstance().getTime().getTime()));
		this.votedProject = project;
		this.votingUser = user;
		this.campaign = campaign;
	}
	
	public Project getVotedProject() {
		return votedProject;
	}

	public void setVotedProject(Project votedProject) {
		this.votedProject = votedProject;
	}

	public User getVotingUser() {
		return votingUser;
	}

	public void setVotingUser(User votingUser) {
		this.votingUser = votingUser;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	
}
