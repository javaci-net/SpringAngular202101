import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AccountComponent} from './account/account.component';
import {ServiceComponent} from './service/service.component';
import {CompenentInteractionComponent} from './compenent-interaction/compenent-interaction.component';
import {ContentProjectionComponent} from './content-projection/content-projection.component';
import {LoopsComponent} from './loops/loops.component';
import {Forms1Component} from './forms1/forms1.component';
import {Forms2Component} from './forms2/forms2.component';

const routes: Routes = [
  {path: "" , redirectTo:'home' , pathMatch:"full"} ,
  {path:"home" , component:HomeComponent },
  {path:"accounts" , component:AccountComponent},
  {path:"services" , component:ServiceComponent},
  {path:"component-interaction" , component:CompenentInteractionComponent},
  {path:"content-projection" , component:ContentProjectionComponent},
  {path:"loops" , component:LoopsComponent},
  {path:"tb-forms" , component:Forms1Component},
  {path:"dy-forms" , component:Forms2Component},
  {path:"**" , component:ServiceComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
