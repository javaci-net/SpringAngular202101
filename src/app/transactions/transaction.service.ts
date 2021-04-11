import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ITransaction } from '../shared/models/dto';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private httpClient:HttpClient , @Inject('API') private api) {
   }

   getTransactions() : Observable<Array<ITransaction>>{
    let url = `${this.api}/transaction/list`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.get<Array<ITransaction>>(url, { headers})
   }
}
