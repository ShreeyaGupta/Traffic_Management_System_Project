import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RoadListComponent } from './road-list/road-list.component';
import { CreateRoadComponent } from './create-road/create-road.component';
import { FormsModule } from '@angular/forms';
import { UpdateRoadComponent } from './update-road/update-road.component';
import { RoadDetailsComponent } from './road-details/road-details.component';
import { TrafficListComponent } from './traffic-list/traffic-list.component';

@NgModule({
  declarations: [
    AppComponent,
    RoadListComponent,
    CreateRoadComponent,
    UpdateRoadComponent,
    RoadDetailsComponent,
    TrafficListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
