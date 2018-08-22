package com.nts.pjt5_6.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.dto.CommentWrite;
import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.service.CommentService;

@RestController
@RequestMapping(path = "/api/reservationUserComments")
public class CommentApiController {
	
	@Autowired
	private CommentService commentService;
 	
 	@PostMapping
 	public Comments addComment(CommentWrite userComment) {
 		return commentService.insertReservComment(userComment);
 	}
 	
}
