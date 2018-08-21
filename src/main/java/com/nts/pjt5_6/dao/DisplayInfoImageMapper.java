package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.DisplayInfoImages;

@Mapper
public interface DisplayInfoImageMapper {
	public List<DisplayInfoImages> selectDisplayImagesInfo(int dpInfoId);
}
