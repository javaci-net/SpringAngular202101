import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {DirectComponent} from './direct/direct.component';
import {MessageService} from '../message.service';

@Component({
  selector: 'app-compenent-interaction',
  templateUrl: './compenent-interaction.component.html',
  styleUrls: ['./compenent-interaction.component.css']
})
export class CompenentInteractionComponent implements OnInit, AfterViewInit {
  directRelationData = "I'm coming from component-interaction-component"
  dataFromChildComponent = ""
  dataFromUnrelatedComponent = "";

  @ViewChild(DirectComponent) refToChildComponent;

  constructor(private messagesService: MessageService) { }

  ngOnInit(): void {

  }

  receiveDataFromChild(event) {
  this.dataFromChildComponent = event
    this.directRelationData = `You just sent me ${event}`
  }

  ngAfterViewInit(): void {

  }

  resetChild() {
    this.refToChildComponent.dataSentCount = 0;
  }

  getDataFromService() {
    this.dataFromUnrelatedComponent = this.messagesService.getData();
  }

  setDataOnService() {
    this.messagesService.setData(new Date().toISOString())
  }
}
