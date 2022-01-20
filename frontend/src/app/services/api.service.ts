import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  read(){
    return this.http.get<any>("http://localhost:8080/v1/leaderboard");
  }
  constructor(private http:HttpClient) {

  }
}
