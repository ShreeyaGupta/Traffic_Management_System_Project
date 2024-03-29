package com.traffic.management.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrafficDataId implements Serializable{

	private static final long serialVersionUID = 5422474521955731667L;

	@Column(name = "DETECTOR_NAME")
    private String detectorName;

	@Column(name = "ROAD_NAME")
    private String roadName;
	
    @Column(name = "DATE")
    private Date date;

	
	public TrafficDataId() {
		super();
	}

	public TrafficDataId(String detectorName, String roadName, Date date) {
		super();
		this.detectorName = detectorName;
		this.roadName = roadName;
		this.date = date;
	}

	public String getDetectorName() {
		return detectorName;
	}

	public void setDetectorName(String detectorName) {
		this.detectorName = detectorName;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TrafficDataId [detectorName=" + detectorName + ", roadName=" + roadName + ", date=" + date + "]";
	}


	
}