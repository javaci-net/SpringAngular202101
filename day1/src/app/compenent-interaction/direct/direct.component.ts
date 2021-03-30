import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-direct',
  templateUrl: './direct.component.html',
  styleUrls: ['./direct.component.css']
})
export class DirectComponent implements OnInit {
  @Input('dataFromParent') dataFromParent : string;
  @Output() receiveDataFromChild = new EventEmitter<string>();
  childData: any;
  dataSentCount = 0;
  constructor() { }

  ngOnInit(): void {
    if (!this.dataFromParent){
      this.dataFromParent ='No data Provided'
    }
  }

  sendDataToParent() {
    this.receiveDataFromChild.emit(this.childData)
    this.dataSentCount +=1;
  }
}
