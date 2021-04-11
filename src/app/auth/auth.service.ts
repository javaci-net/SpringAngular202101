import {Inject, Injectable} from '@angular/core';
import {ILoginSchema} from '../shared/models/dto';
import {HttpClient} from '@angular/common/http';
import {ILoginResponse} from '../shared/models/HttpModels';
import {UserService} from '../profile/user.service';
import {InformationService} from '../shared/information.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated = false;
  redirectUrl = '';

  constructor(
    @Inject('LOGIN_API') private loginApi: string,
    private httpClient: HttpClient,
    private userService: UserService,
    private infoService: InformationService
  ) {

  }

  async doLogin(loginData: ILoginSchema): Promise<boolean> {
    this.doLogOut();

    try {
      const response = await this.httpClient
        .post<ILoginResponse>(this.loginApi, loginData)
        .toPromise();
      console.log('Login Response : ', response);
      if (response.authResult?.authenticated) {
        if (response.jwtToken != null) {
          localStorage.setItem('access-token', response.jwtToken);
          this.isAuthenticated = true;
          this.infoService.publishInformation(
            {
              message:'Login Success!',
              type:'success'
            }
          )
          return true;
        }
      } else {
        this.infoService.publishInformation(
          {
            message:'Login Failed!',
            type:'warning'
          }
        )
        return false;
      }

    } catch (err) {
      this.infoService.publishInformation(
        {
          message:'Login failed!',
          type:'warning'
        }
      )
      console.log(err);
      return false;
    }

    return true;
  }

  doLogOut() {
    localStorage.removeItem('access-token');
    this.isAuthenticated = false;
    this.userService.clearUser();
  }
}


