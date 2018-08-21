package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.Comments;

@Mapper
public interface ReservationUserCommentMapper {
	public int insertReservUserComment(Comments comment);
	public List<Comments> selectCommentsByDisplayId(int dpInfoId);
}
