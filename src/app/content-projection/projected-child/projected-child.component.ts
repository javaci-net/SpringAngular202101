import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-projected-child',
  templateUrl: './projected-child.component.html',
  styleUrls: ['./projected-child.component.css']
})
export class ProjectedChildComponent implements OnInit {
 @Input('title') title = 'No title'
 @Input('cardTitle') cardTile = "no card title"

  constructor() { }

  ngOnInit(): void {
  }

}
