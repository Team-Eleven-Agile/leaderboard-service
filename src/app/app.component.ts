import {Component, OnInit} from '@angular/core';
import {ApiService} from "./services/api.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'leaderboard-frontend';
  data:any;
  constructor(private api:ApiService) {

  }
  ngOnInit(){
    this.api.read().subscribe(data => {
      this.data = data;
    });
  }
}
