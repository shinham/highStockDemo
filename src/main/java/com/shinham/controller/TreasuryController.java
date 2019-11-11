package com.shinham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinham.service.TreasuryService;
import com.shinham.vo.TreasuryConstantJson;
import com.shinham.vo.TreasuryConstantVo;

@Controller
public class TreasuryController {
	

	@Autowired
    private TreasuryService treasuryService;
	
	@GetMapping("/getFullList")
    public String queryFullList(){
        List<TreasuryConstantVo> tcList = treasuryService.getFullList();
        return "treasury_charts";
    }
	
	@RequestMapping("/getDefaultList")
	@ResponseBody
    public List<TreasuryConstantJson> getDefaultList(){
        List<TreasuryConstantJson> tJsonList = treasuryService.getDefaultData();
        return tJsonList;
    }

}
