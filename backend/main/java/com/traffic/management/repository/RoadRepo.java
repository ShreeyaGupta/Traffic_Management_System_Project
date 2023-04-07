package com.traffic.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traffic.management.model.Road;

public interface RoadRepo extends JpaRepository<Road,Long> {

}
