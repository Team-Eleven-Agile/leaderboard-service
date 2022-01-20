import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormControl} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  username = new FormControl("");

  read(){
    return this.http.get<any>("http://localhost:8080/v1/leaderboard");
  }

  add(){
    return this.http.post('http://localhost:8080/v1/leaderboard/addUser',{username:this.username.value})
  }
  constructor(private http:HttpClient) {

  }
}
