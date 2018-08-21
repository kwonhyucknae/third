package com.nts.pjt5_6.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface DisplayInfoMapper {
	public int selectCountDisplayInfo(@Param("categoryId")int categoryId);
	public double selectAvgScore(int dpInfoId);
}
