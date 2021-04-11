import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input('cardTitle') cardTitle:string ="";
  @Input('cardSubtitle') cardSubtitle:string ="";

  constructor() { }

  ngOnInit(): void {
  }

}
