package com.traffic.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traffic.management.exception.ResourceNotFoundException;
import com.traffic.management.model.Road;
import com.traffic.management.repository.RoadRepo;
import com.traffic.management.service.RoadService;

@Service
public class RoadServiceImpl implements RoadService{

	private RoadRepo roadrepo;
	
	@Autowired
	public RoadServiceImpl(RoadRepo roadrepo) {
		super();
		this.roadrepo = roadrepo;
	}

	@Override
	public Road saveRoad(Road road) {
		return roadrepo.save(road);
	}

	@Override
	public List<Road> getAllRoadDetails() {
		return roadrepo.findAll();
	}
	public Road getRoadById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return roadrepo.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Road", "Id", id));
	}
		
	@Override
	public Road updateRoad(Road road, long id) {
		// first we check if a road with given id exists in db or not
		Road existingRoad=roadrepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Road", "Id", id));
		existingRoad.setRoadName(road.getRoadName());
		existingRoad.setDetectorName(road.getDetectorName());
		existingRoad.setDetectorUp(road.isDetectorUp());
		//save existing road to DB
		roadrepo.save(existingRoad);
		return existingRoad;
	}

	@Override
	public void deleteRoad(long id) {
		//check if road by given id exists in the DB
		roadrepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Road", "Id", id));
        roadrepo.deleteById(id);
		
	}
  
}
