import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {IUser, UserStatuses} from "../shared/models/dto";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private $userSubject:BehaviorSubject<IUser> = new BehaviorSubject<IUser>(null);

  constructor(@Inject('API') private api, private httpClient: HttpClient) {
  }

  getUser():Observable<IUser>{
    let url = `${this.api}/customer/getInfo`;
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.get<IUser>(url ,{headers})
        .pipe(tap(user => this.$userSubject.next(user)))
  }

  listenForUser():Observable<IUser>{
    return this.$userSubject.asObservable()
  }
  clearUser(){
    this.$userSubject.next(null)
  }

  createUser(userData:IUser) : Observable<any>{
    let url = `${this.api}/customer/register`;
    //let token = localStorage.getItem('access-token');
    //let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.post<IUser>(url ,userData)
        
  }
  updateUser(userData:IUser) : Observable<any>{
    let url = `${this.api}/customer/update`;
    userData.status = UserStatuses.ACTIVE
    //let token = localStorage.getItem('access-token');
    //let headers = new HttpHeaders().set('Authorization', token)
    let token = localStorage.getItem('access-token');
    let headers = new HttpHeaders().set('Authorization', token)
    return this.httpClient.put<IUser>(url ,userData, {headers})

  }

}
