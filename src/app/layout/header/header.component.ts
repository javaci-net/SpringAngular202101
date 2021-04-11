import { Component, OnInit } from '@angular/core';
import {InformationService} from "../../shared/information.service";
import {Observable} from "rxjs";
import {IInformation, IUser} from "../../shared/models/dto";
import {UserService} from "../../profile/user.service";
import {AuthService} from "../../auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  info:IInformation;
  $user:Observable<IUser>
  constructor(private infoService:InformationService, private userService:UserService,
              private authService:AuthService,
              private router:Router
  ) { }

  ngOnInit(): void {
    this.infoService.listenForInformation()
        .subscribe(_info =>{
          this.info = _info;
          setTimeout(() => this.info = null , 5000)
        })
    this.$user = this.userService.listenForUser();
  }


  logout() {
    this.authService.logOut();
    return this.router.navigateByUrl('/home')
  }
}
