import { Component, OnInit } from '@angular/core';
import { TrafficData } from '../traffic-data';
import { TrafficService } from '../traffic.service';
import { timer } from 'rxjs/internal/observable/timer';
import { map } from 'rxjs/internal/operators/map';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-traffic-list',
  templateUrl: './traffic-list.component.html',
  styleUrls: ['./traffic-list.component.css']
})
export class TrafficListComponent implements OnInit {
  traffics: TrafficData[];
  timerSubscription: Subscription; 
  constructor(private trafficService:TrafficService) { }

  ngOnInit(): void {
    //     // timer(0, 20000) call the function immediately and every 20 seconds 
        this.timerSubscription = timer(0, 20000).pipe( 
          map(() => { 
            this.getTraffic();
          }) 
        ).subscribe(); 
      }

  private getTraffic(){
    this.trafficService.getTrafficList().subscribe(data => {
       this.traffics = data;
    });
  }
}
