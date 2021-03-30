import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CompenentInteractionComponent } from './compenent-interaction/compenent-interaction.component';
import { DirectComponent } from './compenent-interaction/direct/direct.component';
import { ContentProjectionComponent } from './content-projection/content-projection.component';
import { ProjectedChildComponent } from './content-projection/projected-child/projected-child.component';
import { LoopsComponent } from './loops/loops.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { Forms1Component } from './forms1/forms1.component';
import { Forms2Component } from './forms2/forms2.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CompenentInteractionComponent,
    DirectComponent,
    ContentProjectionComponent,
    ProjectedChildComponent,
    LoopsComponent,
    NotfoundComponent,
    Forms1Component,
    Forms2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule ,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
