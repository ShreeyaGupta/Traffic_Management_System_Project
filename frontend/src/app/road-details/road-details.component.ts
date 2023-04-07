import { Component, OnInit } from '@angular/core';
import { Road } from '../road';
import { ActivatedRoute } from '@angular/router';
import { RoadService } from '../road.service';

@Component({
  selector: 'app-road-details',
  templateUrl: './road-details.component.html',
  styleUrls: ['./road-details.component.css']
})
export class RoadDetailsComponent implements OnInit {
  id: number
  road: Road
  constructor(private route: ActivatedRoute, private roadService: RoadService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.road = new Road();
    this.roadService.getRoadById(this.id).subscribe( data => {
      this.road = data;
    });
  }

}
