package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nts.pjt5_6.dto.CommentWrite;
import com.nts.pjt5_6.dto.Comments;

@Mapper
public interface ReservationUserCommentMapper {
	public int insertReservUserComment(CommentWrite comment);
	public List<Comments> selectCommentsByDisplayId(int dpInfoId);
	public Comments selectCommentsByCommentId(@Param("id")int commentId);
}
