package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Comment;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;

public interface CommentService {
	public Comment save(Project project, User user, String commentText);
}
