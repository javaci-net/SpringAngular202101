import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-projected-child',
  templateUrl: './projected-child.component.html',
  styleUrls: ['./projected-child.component.css']
})
export class ProjectedChildComponent implements OnInit {
  @Input('title') title :string;
  @Input('cardTitle') cardTitle :string;
  constructor() { }

  ngOnInit(): void {
   if (!this.title) {
     this.title = 'default title'
   }
  }

}
