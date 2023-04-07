package com.traffic.management.scheduler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.traffic.management.model.CongestionLevel;
import com.traffic.management.model.Road;
import com.traffic.management.model.TrafficData;
import com.traffic.management.model.TrafficDataId;
import com.traffic.management.repository.RoadRepo;
import com.traffic.management.repository.TrafficDataRepository;

@Component
public class TrafficDataScheduler {
    @Autowired
    RoadRepo roadRepository;
    
    @Autowired
    TrafficDataRepository trafficDataRepository;
    
    final private int MAX_VOLUME = 30;
    
    @PostConstruct
    public void start() {
        ScheduledExecutorService  scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                Date now = new Date();
                List<TrafficData> trafficDataList = new ArrayList<>();
                try {
                    List<Road> roads = roadRepository.findAll();
                    if(!CollectionUtils.isEmpty(roads)) {
                        roads.stream().filter(road -> road.isDetectorUp()).forEach(road ->{
                            TrafficDataId trafficDataId = new TrafficDataId(road.getDetectorName(), road.getRoadName(), now);
                            int classOneVolume = random.nextInt(9) + 1;
                            int classTwoVolume = random.nextInt(9) + 1;
                            int classThreeVolume = random.nextInt(9) + 1;
                            double averageSpeed = random.nextInt(90) + 10.0;
                            int voulume = classOneVolume + classTwoVolume + classThreeVolume;
                            double occupancyPercentage = calculateOccupancyPercentage(voulume);
                            CongestionLevel congestionLevel = calculateCongestionLevel(occupancyPercentage);
                            TrafficData trafficData = new TrafficData();
                            trafficData.setTrafficDataId(trafficDataId);
                            trafficData.setAverageSpeed(averageSpeed);
                            trafficData.setClassOneVolume(classOneVolume);
                            trafficData.setClassTwoVolume(classTwoVolume);
                            trafficData.setClassThreeVolume(classThreeVolume);
                            trafficData.setOccupancyPercentage(occupancyPercentage);
                            trafficData.setPeriod(20);
                            trafficData.setVolume(voulume);
                            trafficData.setCongestionLevel(congestionLevel);
                            trafficDataList.add(trafficData);
                        });
                    }
                    trafficDataRepository.saveAll(trafficDataList);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 20, TimeUnit.SECONDS);
        
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MINUTE, -10);
                System.out.println(calendar.getTime());
                trafficDataRepository.deleteByDateLessThan(calendar.getTime());
            }
        }, 0, 1,  TimeUnit.HOURS);
    }
    
    private double calculateOccupancyPercentage(int volume) {
        double occupancyPercentage = (double) ((volume * 100) / MAX_VOLUME);
        return occupancyPercentage;
    }
    
    private CongestionLevel calculateCongestionLevel(double occupancyPercentage) {
        CongestionLevel congestionLevel = null;
        if(occupancyPercentage > 75) {
            congestionLevel = CongestionLevel.VERY_HIGH;
        }else if (occupancyPercentage >50) {
            congestionLevel = CongestionLevel.HIGH;
        }else {
            congestionLevel = CongestionLevel.NORMAL;
        }
        return congestionLevel;
    }
}