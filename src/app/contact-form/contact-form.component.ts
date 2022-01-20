import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.scss']
})
export class ContactFormComponent implements OnInit {

  username = new FormControl("");
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(){
    return this.http.post('http://localhost:8080/v1/leaderboard',{username:this.username.value}).subscribe((response)=>{console.log(response)})
  }
}
