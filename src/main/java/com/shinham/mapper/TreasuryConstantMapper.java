package com.shinham.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shinham.domain.TreasuryConstant;

@Mapper
public interface TreasuryConstantMapper {
	
	public List<TreasuryConstant> queryFullList();
	
	public List<TreasuryConstant> queryDefaultList(String startDate, String endDate);

}
