package com.traffic.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traffic.management.model.Road;
import com.traffic.management.service.RoadService;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/roads")
public class RoadController {
	private RoadService roadService;

	public RoadController(RoadService roadService) {
		super();
		this.roadService = roadService;
	}

	// build create road REST API
	@PostMapping
	public ResponseEntity<Road> saveRoad(@RequestBody Road road) {
		return new ResponseEntity<Road>(roadService.saveRoad(road), HttpStatus.CREATED);
	}

	// build get all employees REST API
	@GetMapping
	public List<Road> getAllRoadDetails() {
		return roadService.getAllRoadDetails();
	}
	
	//get road by id
	//http://localhost:8080/api/roads/1
	@GetMapping("{id}")
	public ResponseEntity<Road> getRoadById(@PathVariable("id") long RoadId){
		return new ResponseEntity<Road>(roadService.getRoadById(RoadId), HttpStatus.OK);
	}
	
//build update road REST API
//http://localhost:8080/api/roads/1
	@PutMapping("{id}")
	public ResponseEntity<Road> updateRoad(@PathVariable("id") long id, @RequestBody Road road) {
		return new ResponseEntity<Road>(roadService.updateRoad(road, id), HttpStatus.OK);
	}

//build delete road rest api
//http://localhost:8080/api/roads/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRoad(@PathVariable("id") long id) {

		// delete employee from DB
		roadService.deleteRoad(id);

		return new ResponseEntity<String>("Road deleted successfully!.", HttpStatus.OK);
	}

}
