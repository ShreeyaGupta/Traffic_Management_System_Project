import { NgModule } from '@angular/core';
import { Routes, RouterModule,} from '@angular/router';
import { RoadListComponent } from './road-list/road-list.component';
import { CreateRoadComponent } from './create-road/create-road.component';
import { UpdateRoadComponent } from './update-road/update-road.component';
import { RoadDetailsComponent } from './road-details/road-details.component';
import { TrafficListComponent } from './traffic-list/traffic-list.component';

const routes: Routes = [
  {path: 'roads', component: RoadListComponent},
  {path: 'create-road', component: CreateRoadComponent},
  {path: '', redirectTo: 'roads', pathMatch: 'full'},
  {path: 'update-road/:id', component: UpdateRoadComponent},
  {path: 'road-details/:id', component: RoadDetailsComponent},
  {path:'traffic-list', component: TrafficListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
