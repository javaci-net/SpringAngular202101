import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardComponent } from './card/card.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UserFormComponent } from './user-form/user-form.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [CardComponent, UserFormComponent],
  imports: [
    CommonModule,
      FormsModule,
      ReactiveFormsModule,
      HttpClientModule
  ],
  exports: [CardComponent, FormsModule, ReactiveFormsModule, UserFormComponent,
    HttpClientModule]
})
export class SharedModule { }
