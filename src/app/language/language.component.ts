import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'language',
  templateUrl: './language.component.html',
  styleUrls: ['./language.component.scss']
})
export class LanguageComponent implements OnInit {

  language = new FormControl("");
  data:any;
  constructor(private api:ApiService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    return this.api.language(this.language.value).subscribe(data =>{this.data = data});
  }
}