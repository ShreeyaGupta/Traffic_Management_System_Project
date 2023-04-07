import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Road } from './road';

@Injectable({
  providedIn: 'root'
})

//An Observable is a Producer of multiple values, "pushing" them to Observers (Consumers)
export class RoadService {
  private baseURL="http://localhost:8080/api/roads";
  constructor(private httpClient:HttpClient) { }

  getRoadsList():Observable<Road[]>{
    return this.httpClient.get<Road[]>(`${this.baseURL}`);
  }
  createRoad(road: Road): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, road);
  }
  getRoadById(id: number): Observable<Road>{
    return this.httpClient.get<Road>(`${this.baseURL}/${id}`);
  }
  updateRoad(id: number, road: Road): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, road);
  }
  deleteRoad(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
