import { Component } from '@angular/core';
import {FormControl} from "@angular/forms";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.scss']
})
export class ContactFormComponent {

  username = new FormControl("");
  constructor(private api:ApiService) { }

  onSubmit(){
    this.api.add().subscribe((response)=>{console.log(response)});
  }
}
