import { Component, OnInit } from '@angular/core';
import { RoadService } from '../road.service';
import { Road } from '../road';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-road',
  templateUrl: './update-road.component.html',
  styleUrls: ['./update-road.component.css']
})
export class UpdateRoadComponent implements OnInit {

  id: number;
  road: Road = new Road();
  constructor(private roadService: RoadService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  
    this.id = this.route.snapshot.params['id'];

    this.roadService.getRoadById(this.id).subscribe(data => {
      this.road = data;
    }, error => console.log(error));
  }

  onSubmit(){
    
    this.roadService.updateRoad(this.id, this.road).subscribe( data =>{
      this.goToRoadList();
    }, error => console.log(error));
  }

  goToRoadList(){
    this.router.navigate(['/roads']);
  }
}
