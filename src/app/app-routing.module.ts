import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileHomeComponent } from './profile/profile-home/profile-home.component';


const routes: Routes = [
  {path:"" , redirectTo:"home" , pathMatch:'full'},
  {path:"home" , component:HomeComponent},
  {path:"auth/login" , component:LoginComponent},
  {path:"auth/register" , component:RegisterComponent},
  {path:"profile" , component:ProfileHomeComponent},
  { path: 'accounts', loadChildren: () => import('./accounts/accounts.module').then(m => m.AccountsModule) },
  { path: 'transactions', loadChildren: () => import('./transactions/transactions.module').then(m => m.TransactionsModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }

 // forex fc4d2143a2-6e1278df1e-qqyu52

 // crypto 9d639670-af5f-46e9-b5e1-12284c8450f2