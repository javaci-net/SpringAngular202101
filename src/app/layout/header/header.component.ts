import { Component, OnInit } from '@angular/core';
import {UserService} from '../../profile/user.service';
import {AuthService} from '../../auth/auth.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {IInformation, IUser} from '../../shared/models/dto';
import {InformationService} from '../../shared/information.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  // @ts-ignore
  info:IInformation ;
  // @ts-ignore
  $user:Observable<IUser>
  constructor(private userService:UserService ,
              private authService:AuthService,
              private infoService:InformationService,
              private router:Router
  ) { }

  ngOnInit(): void {
   this.$user = this.userService.listenForUser()
    this.infoService.listenForInformation()
      .subscribe(_info =>{
        this.info = _info;
        // @ts-ignore
        setTimeout(()=> this.info=null , 3000)

      })
  }

  logOut(){
    this.authService.doLogOut()
    return this.router.navigateByUrl('/home')
  }

}
