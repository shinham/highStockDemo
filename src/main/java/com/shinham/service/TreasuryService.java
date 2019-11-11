package com.shinham.service;

import java.util.List;

import com.shinham.domain.TreasuryConstant;
import com.shinham.vo.TreasuryConstantJson;
import com.shinham.vo.TreasuryConstantVo;

public interface TreasuryService {

	public List<TreasuryConstantVo> getFullList();

	public List<TreasuryConstantJson> getDefaultData();

}
