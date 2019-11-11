package com.shinham.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinham.domain.TreasuryConstant;
import com.shinham.mapper.TreasuryConstantMapper;
import com.shinham.service.TreasuryService;
import com.shinham.vo.TreasuryConstantJson;
import com.shinham.vo.TreasuryConstantVo;

@Service
public class TreasuryServiceImpl implements TreasuryService{
	
	@Autowired TreasuryConstantMapper treasuryConstantDAO;

	@Override
	public List<TreasuryConstantVo> getFullList() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<TreasuryConstant> tcList = new ArrayList<TreasuryConstant>();
		List<TreasuryConstantVo> voList = new ArrayList<TreasuryConstantVo>();
		tcList = treasuryConstantDAO.queryFullList();
		for (TreasuryConstant treasury : tcList) {
			TreasuryConstantVo theVo = new TreasuryConstantVo();
			theVo.setId(treasury.getId());
			theVo.setObservationDate(sdf.format(treasury.getObservationDate()));
			theVo.setT10Y2Y(treasury.getT10Y2Y());
			voList.add(theVo);
		}
		return voList;
	}
	@Override
	public List<TreasuryConstantJson> getDefaultData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<TreasuryConstant> tcList = new ArrayList<TreasuryConstant>();
		Date date = new Date();
		GregorianCalendar endCal = new GregorianCalendar();
		endCal.setTime(date);
		GregorianCalendar startCal = new GregorianCalendar();
		startCal.setTime(date);
		startCal.add(Calendar.YEAR, -5);
		tcList = treasuryConstantDAO.queryFullList();
		
		List<TreasuryConstantJson> resultList = new ArrayList<TreasuryConstantJson>();
		for (TreasuryConstant tc : tcList) {
			TreasuryConstantJson tcJson = new TreasuryConstantJson();
			tcJson.setObservationDate(tc.getObservationDate().getTime());
			tcJson.setT10Y2Y(tc.getT10Y2Y());
			resultList.add(tcJson);
			
		}
		System.out.println("resultList"+resultList.size());
		return resultList;
		
	}

}
