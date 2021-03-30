import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  name = 'Volkan';
  name1 = 'Huseyin'
  isDisabled = false;
  constructor() { }

  ngOnInit(): void {
  }

  enableDisable(){
    this.isDisabled =!this.isDisabled;
  }
}
