import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileHomeComponent } from './profile-home/profile-home.component';
import {SharedModule} from "../shared/shared.module";



@NgModule({
  declarations: [ProfileHomeComponent],
    imports: [
        CommonModule,
        SharedModule
    ]
})
export class ProfileModule { }
