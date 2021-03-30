import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-direct',
  templateUrl: './direct.component.html',
  styleUrls: ['./direct.component.css']
})
export class DirectComponent implements OnInit {
  childData :any
  @Input('dataFromParent') dataFromParent : string
  @Output() receiveDataFromChild =  new EventEmitter<string>() ;
  dataSentCount = 0;

  constructor() { }

  ngOnInit(): void {
    if (!this.dataFromParent){
        this.dataFromParent = "No data from parent"
    }

  }

  sendDataToParent(){
    this.receiveDataFromChild.emit(this.childData)
    this.dataSentCount +=1
  }

}
