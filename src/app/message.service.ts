import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private sharedData =""
  constructor() { }

  getData(){
    return this.sharedData;
  }

  setData(msg){
    this.sharedData = msg;
  }
}
