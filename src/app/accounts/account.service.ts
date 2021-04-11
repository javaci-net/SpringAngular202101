import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAccount } from '../shared/models/dto';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient:HttpClient , @Inject('API') private api) {
  }

  getAccounts() :Observable<Array<IAccount>>{
    let url = `${this.api}/account/list`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.get<Array<IAccount>>(url, { headers})
  }

  createAccount(accountData:IAccount) : Observable<any>{
    let url = `${this.api}/account/create`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.post(url,accountData, {headers} )
  }

  getAccount(accountId:number):Observable<IAccount>{
    let url = `${this.api}/account/getInfo/${accountId}`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.get<IAccount>(url, { headers})
  }

  closeAccount(accountId:number):Observable<IAccount>{
    let url = `${this.api}/account/close`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.post<IAccount>(url,{accountId}, { headers})
  }
}
