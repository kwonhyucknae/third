package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.ReservationUserCommentImages;

@Mapper
public interface ReservationUserCommentImageMapper {
	public List<ReservationUserCommentImages> selectCommentImagesByCommentId(int commentID);
	public int insertReservationImage(ReservationUserCommentImages reservImage);
}
