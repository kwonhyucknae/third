package com.nts.pjt5_6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt5_6.dao.ReservationUserCommentMapper;
import com.nts.pjt5_6.dao.FileInfoMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentImageMapper;
import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;
import com.nts.pjt5_6.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private ReservationUserCommentMapper commentsMapper;
	@Autowired
	private ReservationUserCommentImageMapper commentsImageMapper;
	@Autowired
	private FileInfoMapper fileMapper;
	
	private static final int FIRST_IMG = 0;
	
	@Override
	@Transactional(readOnly=false)
	public void insertReservComment(Comments comment) {
		commentsMapper.insertReservUserComment(comment);
		
		if(comment.getUserCommentImages() != null) {
			
			ReservationUserCommentImages reservImage = new ReservationUserCommentImages.Builder()
					.setReservationInfoId(comment.getReservationInfoId())
					.setReservationUserCommentId(comment.getId())
					.setFileName(comment.getUserCommentImages().get(FIRST_IMG).getFileName())
					.setSaveFileName(comment.getUserCommentImages().get(FIRST_IMG).getSaveFileName())
					.setContentType(comment.getUserCommentImages().get(FIRST_IMG).getContentType())
					.build();
			
			fileMapper.insertFileInfo(reservImage);
			
			commentsImageMapper.insertReservationImage(reservImage);
		}
		
	}
}
