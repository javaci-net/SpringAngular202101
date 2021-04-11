import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {LoginComponent} from './auth/login/login.component';
import {ProfileHomeComponent} from './profile/profile-home/profile-home.component';
import {AuthGuardGuard} from './auth/auth-guard.guard';
import {RegisterComponent} from './auth/register/register.component';

const routes: Routes = [
  { path:'', redirectTo:"home", pathMatch:'full'  },
  {path:"home" , component:HomeComponent},
  {path:"auth/login" , component:LoginComponent},
  {path:"auth/register" , component:RegisterComponent},
  {path:"profile" , component:ProfileHomeComponent , canActivate:[AuthGuardGuard]},
  {path:'**' , component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
