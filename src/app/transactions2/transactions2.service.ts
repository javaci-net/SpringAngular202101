import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {ITransaction} from "../shared/models/dto";

@Injectable({
  providedIn: 'root'
})
export class Transactions2Service {

  constructor(@Inject('API') private api , private httpClient:HttpClient
  ) { }


  getTransactions():Observable<Array<ITransaction>>{
    let url = `${this.api}/transaction/list`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.get<Array<ITransaction>>(url, {headers})
  }

  doWithdraw(data:ITransactionInput) : Observable<any>{
    let url = `${this.api}/transaction/withdraw?accountId=${data.accountId}&amount=${data.amount}`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.put(url,{}, {headers})

  }

  doTransfer(data:ITransactionInput) {
    let url = `${this.api}/transaction/transfer?accountId=${data.accountId}&amount=${data.amount}&toAccountNumber=${data.toAccountNumber}`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.post(url, {}, {headers})
  }


  doDeposit(data:ITransactionInput){
    let url = `${this.api}/transaction/deposit?`
    let params = new HttpParams()
        .set('amount',`${data.amount}`)
        .set('accountId', `${data.accountId}`)
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)

    return this.httpClient.post(url,{}, {headers , params})
  }


}

export interface ITransactionInput{
  accountId:number , amount:number , toAccountNumber?:number
}

