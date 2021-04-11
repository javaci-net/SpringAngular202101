import {Component, OnInit} from '@angular/core';
import {AuthService} from "../auth.service";
import {ILoginSchema} from "../../shared/models/dto";
import {UserService} from "../../profile/user.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    loginModel: ILoginSchema = {
        password: "",
        username: ""
    }

    constructor(private authService: AuthService,
                private userService:UserService, private router:Router) {
    }

    ngOnInit(): void {
    }

    submitLoginForm() {
        this.authService.doLogin(this.loginModel)
            .then(result => {
                if (result) {
                    console.log("Result : ", result)
                    this.userService.getUser().subscribe(_user =>{
                        console.log("We have got the user : ", _user)
                        let url = this.authService.redirectUrl ? this.authService.redirectUrl : '/home';
                        this.authService.redirectUrl ="";
                        return this.router.navigateByUrl(url)
                    })
                } else {
                    this.loginModel.username = '';
                    this.loginModel.password = '';
                }
            })
            .catch(err => console.log(err))

    }

}
