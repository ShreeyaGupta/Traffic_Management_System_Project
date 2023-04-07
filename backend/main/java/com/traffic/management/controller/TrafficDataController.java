package com.traffic.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traffic.management.dto.DTOHelper;
import com.traffic.management.service.TrafficDataService;
import com.traffic.management.dto.TrafficDataDTO;
import com.traffic.management.model.TrafficData;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TrafficDataController{
	
	@Autowired
	private TrafficDataService trafficDataService;
	
	private DTOHelper dtohelper = new DTOHelper();
	
	@GetMapping("/trafficData") //get all traffic data
	public List<TrafficDataDTO> getAllTrafficData(){
		List<TrafficDataDTO> trafficDTOs = new ArrayList<TrafficDataDTO>();
		List<TrafficData> trafficDatas=trafficDataService.getAllTrafficData();
		for(TrafficData trafficdata:trafficDatas){
			trafficDTOs.add(dtohelper.getTrafficDataDTO(trafficdata));
		}
		return trafficDTOs;
	}
}
//return DTOHelper.getTrafficDataDTO(trafficDataService.getAllTrafficData());