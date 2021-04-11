import { Component, OnInit } from '@angular/core';
import {ILoginSchema} from '../../shared/models/dto';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import {consoleTestResultHandler} from 'tslint/lib/test';
import {UserService} from '../../profile/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginModel : ILoginSchema = {
    password:'',
    username:''
  }
  constructor(private authService:AuthService , private router:Router ,
              private userService:UserService) { }

  ngOnInit(): void {
  }

   submitLoginForm(){
      this.authService.doLogin(this.loginModel)
        .then(result =>{
          if (result){
            this.userService.getUser().subscribe(_user =>{
              let url = this.authService.redirectUrl
                ? this.authService.redirectUrl
                : '/home'

              this.authService.redirectUrl ='';
              return this.router.navigateByUrl(url)
            })

          }else{
            this.loginModel.username ='';
            this.loginModel.password =''
          }
        }).catch(err =>{
        this.loginModel.username ='';
        this.loginModel.password = ''
      })
  }

}
