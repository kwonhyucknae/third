package com.nts.pjt5_6.service.impl;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt5_6.dao.ReservationUserCommentMapper;
import com.nts.pjt5_6.dao.FileInfoMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentImageMapper;
import com.nts.pjt5_6.dto.CommentWrite;
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
	
	private static final String FILE_UPLOAD_LOCATION = "c:/tmp/";
	
	@Override
	@Transactional(readOnly=false)
	public Comments insertReservComment(CommentWrite comment) {
		commentsMapper.insertReservUserComment(comment);
		
		if(comment.getCommentImageFile() != null) {
			String localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.M.d_HH.mm.ss"));
			String saveFileName = "img/" + localDate + comment.getCommentImageFile().getOriginalFilename();
			
			ReservationUserCommentImages reservImage = new ReservationUserCommentImages.Builder()
					.setReservationInfoId(comment.getReservationInfoId())
					.setReservationUserCommentId(comment.getId())
					.setFileName(comment.getCommentImageFile().getOriginalFilename())
					.setSaveFileName(saveFileName)
					.setContentType(comment.getCommentImageFile().getContentType())
					.build();
			
			fileMapper.insertFileInfo(reservImage);
			commentsImageMapper.insertReservationImage(reservImage);
			
			try (FileOutputStream fileOutput = new FileOutputStream(FILE_UPLOAD_LOCATION + saveFileName);
				 InputStream inputStream = comment.getCommentImageFile().getInputStream();) {
				
				int readCount = 0;
				byte[] buffer = new byte[1024];
				
				while ((readCount = inputStream.read(buffer)) != -1) {
					fileOutput.write(buffer, 0, readCount);
				}
			} catch (Exception ex) {
				throw new RuntimeException("file Save Error");
			}
		}
		return commentsMapper.selectCommentsByCommentId(comment.getId());
	}
	
	
}
