package com.traffic.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.traffic.management.exception.NotFoundException;
//import com.traffic.management.exception.ResourceNotFoundException;
import com.traffic.management.model.TrafficData;
import com.traffic.management.repository.TrafficDataRepository;
import com.traffic.management.service.TrafficDataService;

@Service
public class TrafficDataServiceImpl implements TrafficDataService{
	@Autowired
    private TrafficDataRepository trafficDataRepository;
	
	@Override
	public List<TrafficData>getAllTrafficData(){
		List<TrafficData> trafficData=new ArrayList<>();
		trafficDataRepository.findAll(Sort.by(Sort.Direction.DESC,"TrafficDataId.date")).forEach(trafficData::add);
		if(trafficData.isEmpty()) {
			throw new NotFoundException("file not found");
		}
	    return trafficData;
	}
}

//Road existingRoad=roadrepo.findById(id).orElseThrow(
//		() -> new ResourceNotFoundException("Road", "Id", id));