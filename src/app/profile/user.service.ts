import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {IUser, UserStatuses} from '../shared/models/dto';
import {tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // @ts-ignore
  private $userSubject:BehaviorSubject<IUser> = new BehaviorSubject<IUser>(null)

  constructor(@Inject('API') private api :string , private httpClint :HttpClient) { }

  getUser() : Observable<IUser>{
    //let url = this.api +"/customer/getInfo"
    let url = `${this.api}/customer/getInfo`
    let token :string | null = localStorage.getItem('access-token')

    let headers = new HttpHeaders()
      .set ('Authorization', <string>token)
    return this.httpClint.get<IUser>(url , {headers})
      .pipe(
        tap(user => this.$userSubject.next(user))
      )
  }

  listenForUser():Observable<IUser>{
    return this.$userSubject.asObservable()
  }
  clearUser(){
    // @ts-ignore
    this.$userSubject.next(null)
  }

  createUser(userData:IUser) :Observable<any>{
    let url = `${this.api}/customer/register`
    return this.httpClint.post(url , userData)
  }

  updateUser(userData:IUser) :Observable<any>{
    userData.status =UserStatuses.ACTIVE
    let token :string | null = localStorage.getItem('access-token')
    let headers = new HttpHeaders()
      .set ('Authorization', <string>token)
    let url = `${this.api}/customer/update`
    return this.httpClint.put(url , userData, {headers})
      .pipe(
        tap(() => this.getUser())
      )
  }
}
