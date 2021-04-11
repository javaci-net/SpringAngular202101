import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Route, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService:AuthService, private router:Router) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const url = state.url;
    if (this.checkLogin(url)){
      return true;
    }
    this.router.navigateByUrl('/auth/login')
    return false  ;
  }
  canLoad(route: Route): boolean|UrlTree{
    let url = route.path;
    if (this.checkLogin(url)){
      return true;
    }
    this.router.navigateByUrl('/auth/login')
    return false  ;
  }

  checkLogin (url){
    return true;
    if (this.authService.isAuthenticated){
      return true;
    }
    this.authService.redirectUrl = url;
    return false;
  }
  
}
