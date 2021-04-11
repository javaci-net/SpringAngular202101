import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {IInformation} from "./models/dto";

@Injectable({
  providedIn: 'any'
})
export class InformationService {
  private $informationSubject:BehaviorSubject<IInformation> = new BehaviorSubject<any>(null)
  constructor() { }

  listenForInformation():Observable<any>{
    return this.$informationSubject.asObservable()
  }

  publishInformation(info:IInformation){
    this.$informationSubject.next(info)
  }
}
