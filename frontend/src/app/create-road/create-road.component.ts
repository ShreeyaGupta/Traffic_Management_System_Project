import { Component, OnInit } from '@angular/core';
import { Road } from '../road';
import { RoadService } from '../road.service';
import {Router} from '@angular/router'

@Component({
  selector: 'app-create-road',
  templateUrl: './create-road.component.html',
  styleUrls: ['./create-road.component.css']
})
export class CreateRoadComponent implements OnInit {
  road:Road=new Road();
  constructor(private roadService:RoadService,
    private router:Router) { }

  ngOnInit(): void {
  }
  // saveRoad(){
  //   this.roadService.createRoad(this.road).subscribe( data =>{
  //     console.log(data);
  //     this.goToRoadList();
  //   },
  //   error => console.log(error));
  // }

  saveRoad(){
    this.roadService.createRoad(this.road).subscribe( data =>{
      console.log(data);
      this.goToRoadList();
    });
  }
  // this.roadService.getRoadsList().subscribe(data => {
  //   this.roads = data;
  // });
  goToRoadList(){
    this.router.navigate(['/roads']);
  }
  onSubmit(){
    console.log(this.road);
    this.saveRoad();
  }
}
