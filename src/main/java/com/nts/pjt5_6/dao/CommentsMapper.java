package com.nts.pjt5_6.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;

@Mapper
public interface CommentsMapper {
	public int insertReservUserComment(Comments comment);
	public int insertFileInfo(ReservationUserCommentImages reservImage);
	public int insertReservationImage(ReservationUserCommentImages reservImage);
}
