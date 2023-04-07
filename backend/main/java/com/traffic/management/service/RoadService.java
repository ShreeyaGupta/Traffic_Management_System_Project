package com.traffic.management.service;

import com.traffic.management.model.Road;

import java.util.List;

public interface RoadService {
	Road saveRoad(Road road);
	List<Road>getAllRoadDetails();
	Road getRoadById(long id);
	Road updateRoad(Road road,long id);
	void deleteRoad(long id);
}
