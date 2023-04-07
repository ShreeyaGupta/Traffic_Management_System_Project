package com.traffic.management.repository;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.traffic.management.model.TrafficData;
import com.traffic.management.model.TrafficDataId;

@Repository
public interface TrafficDataRepository extends JpaRepository<TrafficData,TrafficDataId> {
	
    
	@Modifying
	@Transactional
	@Query(value="DELETE FROM traffic_data td WHERE td.trafficDataId.date<:date",nativeQuery = true)
	void deleteByDateLessThan(@Param("date")Date date);
//    @Query(value ="DELETE t from traffic_data t WHERE t.date<d",nativeQuery = true)
//	void deleteByDateLessThan(@Param("date")Date d);



}



