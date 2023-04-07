package com.traffic.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="roadtable")
public class Road {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROAD_ID")
	private long roadId;
	@Column(name="ROAD_NAME")
	private String roadName;
	@Column(name="DETECTOR_NAME")
	private String detectorName;
	@Column(name="DETECTOR_UP")
	private boolean detectorUp;
	public Road(String roadName, String detectorName, boolean detectorUp) {
		super();
		this.roadName = roadName;
		this.detectorName = detectorName;
		this.detectorUp = detectorUp;
	}
	public Road() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Road [roadId=" + roadId + ", roadName=" + roadName + ", detectorName=" + detectorName + ", detectorUp="
				+ detectorUp + "]";
	}
	public long getRoadId() {
		return roadId;
	}
	public void setRoadId(long roadId) {
		this.roadId = roadId;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getDetectorName() {
		return detectorName;
	}
	public void setDetectorName(String detectorName) {
		this.detectorName = detectorName;
	}
	public boolean isDetectorUp() {
		return detectorUp;
	}
	public void setDetectorUp(boolean detectorUp) {
		this.detectorUp = detectorUp;
	}
	
	
}
