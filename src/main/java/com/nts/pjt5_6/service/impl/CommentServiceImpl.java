package com.nts.pjt5_6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt5_6.dao.CommentsMapper;
import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;
import com.nts.pjt5_6.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentsMapper commentsMapper;
	
	@Override
	@Transactional(readOnly=false)
	public void insertReservComment(Comments comment) {
		commentsMapper.insertReservUserComment(comment);
		ReservationUserCommentImages reservImage = new ReservationUserCommentImages.Builder()
				.setReservationInfoId(1)
				.setReservationUserCommentId(comment.getId())
				.setFileName(comment.getUserCommentImages().get(0).getFileName())
				.setSaveFileName(comment.getUserCommentImages().get(0).getSaveFileName())
				.setContentType(comment.getUserCommentImages().get(0).getContentType())
				.build();
		
		commentsMapper.insertFileInfo(reservImage);
		System.out.println("insertFile 후에 "+reservImage);
		
		commentsMapper.insertReservationImage(reservImage);
		
	}
}
