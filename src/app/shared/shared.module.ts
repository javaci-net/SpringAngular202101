import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CardComponent } from './card/card.component';
import { UserFormComponent } from './user-form/user-form.component';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [
    CardComponent,
    UserFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports: [FormsModule, ReactiveFormsModule, CardComponent, UserFormComponent]
})
export class SharedModule { }
