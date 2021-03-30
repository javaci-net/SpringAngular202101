import {Component, OnInit, ViewChild} from '@angular/core';
import {DirectComponent} from './direct/direct.component';
import {MessageService} from '../message.service';

@Component({
  selector: 'app-compenent-interaction',
  templateUrl: './compenent-interaction.component.html',
  styleUrls: ['./compenent-interaction.component.css']
})
export class CompenentInteractionComponent implements OnInit {
  directRelationData = 'Data from parent';
  dataFromChildComponent = ""

  dataFromUnrelatedComponent ;

  @ViewChild(DirectComponent) refToChildComponent;

  constructor(private  messageService : MessageService) {

  }

  ngOnInit(): void {
  }

  receiveDataFromChild($event: string) {
   this.dataFromChildComponent = $event
  }

  resetChild(){
    this.refToChildComponent.dataSentCount = 0;
  }

  getDataFromService(){
    this.dataFromUnrelatedComponent = this.messageService.getData()
  }

  setDataOnService(){
    this.messageService.setData(new Date().toISOString())
  }
}
