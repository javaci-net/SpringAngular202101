import {Component, OnInit, Input} from '@angular/core';
import {UserService} from '../../profile/user.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {IUser} from '../models/dto';
import {InformationService} from '../information.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  @Input('mode') mode: any;
  cardTitle = 'Register';
  subTitle = 'Please create an account!';
  btntext = 'Register';
  link = {
    text: 'Already have an account? Sign in',
    url: '/auth/login'
  };

  userForm: FormGroup;
  citizenNumber: FormControl = new FormControl('',
    [Validators.required,
      Validators.minLength(11)]);
  email: FormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);
  firstName: FormControl = new FormControl('', [Validators.required]);
  lastName: FormControl = new FormControl('', [Validators.required]);
  birthDate: FormControl = new FormControl('1981-12-25');
  phoneNumber: FormControl = new FormControl();
  password: FormControl = new FormControl("",[Validators.required]);

  currentUser :IUser

  constructor(private userService: UserService, private router: Router, private infoService:InformationService) {
    this.userForm = new FormGroup({
      firstName: this.firstName,
      email: this.email,
      lastName: this.lastName,
      birthDate: this.birthDate,
      phoneNumber: this.phoneNumber,
      citizenNumber: this.citizenNumber,
      password: this.password,
    })
  }

  ngOnInit(): void {
    if (this.mode == 'profile') {
      this.cardTitle = 'Update';
      this.subTitle = 'Update your profile';
      this.btntext = 'Update';
      this.userService.listenForUser()
        .subscribe(_user => {
          this.currentUser = _user
          console.log("Isu = ", this.currentUser)
          this.citizenNumber.setValue(this.currentUser.citizenNumber)
          this.firstName.setValue(this.currentUser.firstName)
          this.email.setValue(this.currentUser.email)
          this.lastName.setValue(this.currentUser.lastName)
          this.phoneNumber.setValue(this.currentUser.phoneNumber)
        })

    }
    this.userForm.valueChanges.subscribe(_changes => console.log("change :" , _changes))
    this.email.valueChanges.subscribe(_email => console.log(_email))
  }

  handleSubmission(){
    if (this.mode ==='register'){
      this.registerUser()
    }else{
      this.updateUser()
    }
  }

  registerUser(){
    this.userService.createUser(this.userForm.value)
      .subscribe(_res => {
        console.log('user created : ', _res);

        return this.router.navigateByUrl('/auth/login')
      })
  }

  updateUser(){
    console.log("user form : ", this.userForm.value)
    this.userService.updateUser(this.userForm.value)
      .subscribe(_res => {
        console.log('user updated : ', _res);
        this.infoService.publishInformation({type:'success', message:'Profile Updated!'})
        //return this.router.navigateByUrl('/auth/login')
      })
  }
}
