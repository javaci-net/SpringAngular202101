import {Inject, Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {ILoginSchema} from "../shared/models/dto";
import {ILoginResponse} from "../shared/models/HttpModels";
import {InformationService} from "../shared/information.service";
import {UserService} from "../profile/user.service";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    isAuthenticated  = false;
    redirectUrl:string;
    constructor(@Inject('LOGIN_API') private loginApi,
                private httpClient: HttpClient,
                private infoService:InformationService,
                private userService: UserService
    ) {
    }

    async doLogin(loginData: ILoginSchema): Promise<boolean> {
        this.logOut();
        try {
            const response = await this.httpClient.post<ILoginResponse>(this.loginApi, loginData)
                .toPromise()
            console.log("Login Response : ", response)
            if (response.authResult.authenticated) {
                localStorage.setItem('access-token', response.jwtToken);
                this.isAuthenticated = true;
                this.infoService.publishInformation({type:'success', message:'Login Successful!'})
                return true
            } else {
                this.infoService.publishInformation({type:'warning', message:'Login Failed!'})
                return false
            }
        } catch (err) {
            console.log(err)
            this.infoService.publishInformation({type:'warning', message:'Login Failed!'})
            return undefined;
        }

    }

     logOut(){
        localStorage.removeItem('access-token')
        this.isAuthenticated = false;
        this.userService.clearUser()
         console.log("user has been cleared");
     }
}
