import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {IInformation} from './models/dto';

@Injectable({
  providedIn: 'root'
})
export class InformationService {

  // @ts-ignore
  private $informationSubject:BehaviorSubject<IInformation> = new BehaviorSubject<IInformation>(null)
  constructor() { }

  listenForInformation():Observable<IInformation>{
    return this.$informationSubject.asObservable()
  }

  publishInformation(info: IInformation){
    this.$informationSubject.next(info)
  }
}
