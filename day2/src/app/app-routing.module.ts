import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompenentInteractionComponent } from './compenent-interaction/compenent-interaction.component';
import { ContentProjectionComponent } from './content-projection/content-projection.component';
import { Forms1Component } from './forms1/forms1.component';
import { Forms2Component } from './forms2/forms2.component';
import { HomeComponent } from './home/home.component';
import { LoopsComponent } from './loops/loops.component';
import { NotfoundComponent } from './notfound/notfound.component';

const routes: Routes = [

  {path: "" , redirectTo:'home' , pathMatch:"full"} ,
  {path:"home" , component:HomeComponent },

  {path:"component-interaction" , component:CompenentInteractionComponent},
  {path:"content-projection" , component:ContentProjectionComponent},
  {
    path: "loops", component: LoopsComponent
  },
  {path:"tb-forms" , component:Forms1Component},
  {path:"dy-forms" , component:Forms2Component},
  {path:"**" , component:NotfoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
