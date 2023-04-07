package com.traffic.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="traffic_data")
public class TrafficData implements Serializable{

    private static final long serialVersionUID = 3309792050686058989L;
    @EmbeddedId
    private TrafficDataId trafficDataId;
//    @Column(name="ROAD_NAME")
//	private String roadName;
//	@Column(name="DETECTOR_NAME")
//	private String detectorName;
    @Column(name = "OCCUPANCY")
    private Double occupancyPercentage;
    @Column(name = "SPEED")
    private Double averageSpeed;
    @Column(name = "VOLUME")
    private Integer volume;
    @Column(name = "C1_VOLUME")
    private Integer classOneVolume;
    @Column(name = "C2_VOLUME")
    private Integer classTwoVolume;
    @Column(name = "C3_VOLUME")
    private Integer classThreeVolume;
    @Column(name = "PERIOD")
    private Integer period;
    @Column(name = "CONGESTION_LEVEL")
    private CongestionLevel congestionLevel = CongestionLevel.NORMAL;
    
	public TrafficData() {
		super();
	}
	
//	public String getRoadName() {
//		return roadName;
//	}
//
//	public void setRoadName(String roadName) {
//		this.roadName = roadName;
//	}
//
//	public String getDetectorName() {
//		return detectorName;
//	}
//
//	public void setDetectorName(String detectorName) {
//		this.detectorName = detectorName;
//	}

	public TrafficDataId getTrafficDataId() {
		return trafficDataId;
	}
	public void setTrafficDataId(TrafficDataId trafficDataId) {
		this.trafficDataId = trafficDataId;
	}
	public Double getOccupancyPercentage() {
		return occupancyPercentage;
	}
	public void setOccupancyPercentage(Double occupancyPercentage) {
		this.occupancyPercentage = occupancyPercentage;
	}
	public Double getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getClassOneVolume() {
		return classOneVolume;
	}
	public void setClassOneVolume(Integer classOneVolume) {
		this.classOneVolume = classOneVolume;
	}
	public Integer getClassTwoVolume() {
		return classTwoVolume;
	}
	public void setClassTwoVolume(Integer classTwoVolume) {
		this.classTwoVolume = classTwoVolume;
	}
	public Integer getClassThreeVolume() {
		return classThreeVolume;
	}
	public void setClassThreeVolume(Integer classThreeVolume) {
		this.classThreeVolume = classThreeVolume;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public CongestionLevel getCongestionLevel() {
		return congestionLevel;
	}
	public void setCongestionLevel(CongestionLevel congestionLevel) {
		this.congestionLevel = congestionLevel;
	}

//	@Override
//	public String toString() {
//		return "TrafficData [trafficDataId=" + trafficDataId + ", roadName=" + roadName + ", detectorName="
//				+ detectorName + ", occupancyPercentage=" + occupancyPercentage + ", averageSpeed=" + averageSpeed
//				+ ", volume=" + volume + ", classOneVolume=" + classOneVolume + ", classTwoVolume=" + classTwoVolume
//				+ ", classThreeVolume=" + classThreeVolume + ", period=" + period + ", congestionLevel="
//				+ congestionLevel + "]";
//	}

	@Override
	public String toString() {
		return "TrafficData [trafficDataId=" + trafficDataId + ", occupancyPercentage=" + occupancyPercentage
				+ ", averageSpeed=" + averageSpeed + ", volume=" + volume + ", classOneVolume=" + classOneVolume
				+ ", classTwoVolume=" + classTwoVolume + ", classThreeVolume=" + classThreeVolume + ", period=" + period
				+ ", congestionLevel=" + congestionLevel + "]";
	}
	
	
}
	
