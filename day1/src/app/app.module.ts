import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { AccountComponent } from './account/account.component';
import { ServiceComponent } from './service/service.component';
import { NotfoundComponent } from './notfound/notfound.component';

import { CompenentInteractionComponent } from './compenent-interaction/compenent-interaction.component';
import { DirectComponent } from './compenent-interaction/direct/direct.component';
import { ContentProjectionComponent } from './content-projection/content-projection.component';
import { ProjectedChildComponent } from './content-projection/projected-child/projected-child.component';
import { LoopsComponent } from './loops/loops.component';
import { Forms1Component } from './forms1/forms1.component';
import { Forms2Component } from './forms2/forms2.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AccountComponent,
    ServiceComponent,
    NotfoundComponent,
    CompenentInteractionComponent,
    DirectComponent,
    ContentProjectionComponent,
    ProjectedChildComponent,
    LoopsComponent,
    Forms1Component,
    Forms2Component,

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
