import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

@Input('cardTitle') cardTitle;
@Input('cardSubtitle') cardSubtitle;

  constructor() { }

  ngOnInit(): void {
  }

}
