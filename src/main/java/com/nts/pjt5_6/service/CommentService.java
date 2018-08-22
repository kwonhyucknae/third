package com.nts.pjt5_6.service;

import com.nts.pjt5_6.dto.CommentWrite;
import com.nts.pjt5_6.dto.Comments;

public interface CommentService {
	public Comments insertReservComment(CommentWrite comment);
}
