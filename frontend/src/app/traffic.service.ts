import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TrafficData } from './traffic-data';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TrafficService {
  private baseURL="http://localhost:8080/api/v1/trafficData";
  constructor(private httpClient:HttpClient) { }
  getTrafficList():Observable<TrafficData[]>{
    return this.httpClient.get<TrafficData[]>(`${this.baseURL}`);
  }
}
