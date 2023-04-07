import { Component, OnInit } from '@angular/core';
import {Road} from '../road'
import { RoadService } from '../road.service';
import {Router} from '@angular/router'

@Component({
  selector: 'app-road-list',
  templateUrl: './road-list.component.html',
  styleUrls: ['./road-list.component.css']
})
export class RoadListComponent implements OnInit {
  roads:Road[];
  constructor(private roadService:RoadService,
    private router:Router) { }

  ngOnInit(): void {
    this.getRoads();
  }
  private getRoads(){ //we need to subscribe to use the methods of service
    this.roadService.getRoadsList().subscribe(data => {
      this.roads = data;
    });
  }

  roadDetails(id: number){
    this.router.navigate(['road-details', id]);
  }
  
  updateRoad(id:number){
    this.router.navigate(['update-road', id]);
  }

  deleteRoad(id: number){
    this.roadService.deleteRoad(id).subscribe( data => {
      console.log(data);
      this.getRoads();
    })
  }
}
