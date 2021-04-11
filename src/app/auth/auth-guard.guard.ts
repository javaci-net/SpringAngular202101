import { Injectable } from '@angular/core';
import {CanActivate, CanLoad, Route, UrlSegment, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate, CanLoad {
  constructor(private authService: AuthService , private router : Router) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> |
    boolean | UrlTree {
    const url = state.url;
    return this.checkUser(url)
  }
  canLoad(
    route: Route,
    segments: UrlSegment[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean |
    UrlTree {
    const url = route.path;
    return this.checkUser(<string> url)
  }

  private checkUser(url :string){
    //return true;
    if (this.authService.isAuthenticated){
      return true
    }else{
      this.authService.redirectUrl = url
      this.router.navigateByUrl('/auth/login')
      return false
    }
  }
}
