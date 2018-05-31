package com.application.initiatives_platform.InitiativesPlatformServer.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Comment;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.Project;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.data.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired CommentRepository commentRepository;
	
	@Override
	public Comment save(Project project, User user, String commentText) {
		
		Comment comment = new Comment(user, commentText);
		
		commentRepository.save(comment);
		
		return comment;
	}
	
}
