package com.nts.pjt5_6.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.ReservationUserCommentImages;

@Mapper
public interface FileInfoMapper {
	public int insertFileInfo(ReservationUserCommentImages reservImage);
}
