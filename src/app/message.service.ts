import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private sharedData = "no one has set to me so far"

  constructor() { }

  getData(){
    return this.sharedData;
  }

  setData(msg :string){
    this.sharedData = msg

  }

}
