import { Component, OnInit, Input } from "@angular/core";
import { Router } from "@angular/router";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { UserService } from 'src/app/profile/user.service';
import { InformationService } from '../information.service';
import {IUser} from "../models/dto";

@Component({
  selector: "app-user-form",
  templateUrl: "./user-form.component.html",
  styleUrls: ["./user-form.component.css"],
})
export class UserFormComponent implements OnInit {
  @Input("mode") mode;
  cardTitle = "Register";
  subTitle = "Please create an account!";
  link = {
    text: "Already have an account? Sign in",
    url: "/auth/login",
  };

  userForm: FormGroup;
  email: FormControl = new FormControl("", [
    Validators.required,
    Validators.email,
  ]);
  firstName: FormControl = new FormControl("", [Validators.required]);
  lastName: FormControl = new FormControl("",[Validators.required]);
  birthDate: FormControl = new FormControl("1981-12-25");
  phoneNumber: FormControl = new FormControl();
  citizenNumber: FormControl = new FormControl("",[
    Validators.required,
    Validators.minLength(11),
    Validators.maxLength(11),
  ]);
  password: FormControl = new FormControl("",[Validators.required]);


  currentUser: IUser
  constructor(private router: Router, private userService : UserService ,
     private infoService:InformationService) {
    this.userForm = new FormGroup({
      firstName: this.firstName,
      email: this.email,
      lastName: this.lastName,
      birthDate: this.birthDate,
      phoneNumber: this.phoneNumber,
      citizenNumber: this.citizenNumber,
      password: this.password,
    });
  }

  ngOnInit(): void {
    if (this.mode == "update") {
      this.cardTitle = "Update";
      this.subTitle = "Update Your Profile";
      this.userService.listenForUser()
          .subscribe(_user => {
            if (_user){
              this.currentUser = _user;
              this.citizenNumber.setValue(this.currentUser.citizenNumber);
              this.firstName.setValue(this.currentUser.firstName)
              this.lastName.setValue(this.currentUser.lastName)
              this.email.setValue(this.currentUser.email)
              this.phoneNumber.setValue(this.currentUser.phoneNumber)
            }
          })
    } else {
      this.mode = "register";
    }
  }

  navigate(url: string) {
    this.router.navigateByUrl(url);
  }

  handleUserForm() {
    if (this.mode == "register") {
      this.registerUser();
    } else {
      this.updateUser();
    }
  }

  private registerUser() {
    this.userService.createUser(this.userForm.value)
    .subscribe(_res => {
      this.infoService.publishInformation({
        message:'Your account has been created!',
        type:'Success'
      })
      return this.router.navigateByUrl("/auth/login")
    })
  }

  private updateUser() {
    this.userService.updateUser(this.userForm.value)
        .subscribe(_res => {
          this.infoService.publishInformation({
            message:'User Updated!',
            type:'success'
          })
        })
  }
}
