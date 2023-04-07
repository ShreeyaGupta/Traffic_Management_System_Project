package com.traffic.management.dto;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

//import org.springframework.data.domain.Sort;

import com.traffic.management.model.TrafficData;



public class DTOHelper{
	public TrafficDataDTO getTrafficDataDTO(TrafficData trafficData) {
		TrafficDataDTO trafficDataDTO=new TrafficDataDTO();
		trafficDataDTO.setRoadName(trafficData.getTrafficDataId().getRoadName());
		trafficDataDTO.setDetectorName(trafficData.getTrafficDataId().getDetectorName());
		trafficDataDTO.setOccupancyPercentage(trafficData.getOccupancyPercentage());
		trafficDataDTO.setAverageSpeed(trafficData.getAverageSpeed());
		trafficDataDTO.setVolume(trafficData.getVolume());
		trafficDataDTO.setClassOneVolume(trafficData.getClassOneVolume());
		trafficDataDTO.setClassTwoVolume(trafficData.getClassTwoVolume());
		trafficDataDTO.setClassThreeVolume(trafficData.getClassThreeVolume());
		trafficDataDTO.setPeriod(trafficData.getPeriod());
		trafficDataDTO.setDate(trafficData.getTrafficDataId().getDate());
		trafficDataDTO.setCongestionLevel(trafficData.getCongestionLevel().getValue());
		return trafficDataDTO;
	}
}

//public class DTOHelper {
//	//DTOHelper.getTrafficDataDTO
//	public List<TrafficDataDTO> getTrafficDataDTO(List<TrafficData>trafficData) {
//		List<TrafficDataDTO> list=new ArrayList<>();
//		for(TrafficData t: trafficData) {
//		  TrafficDataDTO trafficDataDTO=new TrafficDataDTO(
//		    t.getTrafficDataId().getRoadName(),
//		    t.getTrafficDataId().getDetectorName(),
//			t.getOccupancyPercentage(),
//			t.getAverageSpeed(),
//			t.getVolume(),
//			t.getClassOneVolume(),
//			t.getClassTwoVolume(),
//			t.getClassThreeVolume(),
//			t.getPeriod(),
//			t.getTrafficDataId().getDate(),
//			t.getCongestionLevel()
//		  );
//		  list.add(trafficDataDTO);
//		}
//		return list;
//	}
//}


//private List<AddressEntity> convertDtoToEntity(List<AddressDto> aDto) {
//    List<AddressEntity> newAddressEntityList = new ArrayList<>();
//
//    for (AddressDto dto : aDto) {
//        AddressEntity addressEntity = new AddressEntity(
//                dto.getUnitNo(),
//                dto.getFloorNo(),
//                dto.getBuildingName(),
//                dto.getAreaName()
//        );
//        
//        newAddressEntityList.add(addressEntity);
//    }
//
//    return newAddressEntityList;
//}
//

//public List<TrafficData>getAllTrafficData(){
//	List<TrafficData> trafficData=new ArrayList<>();
//	trafficDataRepository.findAll(Sort.by(Sort.Direction.DESC,"TrafficDataId.date")).forEach(trafficData::add);
//    return trafficData;
//}

//public List<TrafficDataDTO>getAllTrafficData(){
//	return DTOHelper.getTrafficDataDTO(trafficDataService.getAllTrafficData());
//	
//}