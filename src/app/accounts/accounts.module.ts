import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountsRoutingModule } from './accounts-routing.module';
import { AccountsComponent } from './accounts.component';
import { SharedModule } from '../shared/shared.module';
import { AccountFormComponent } from './account-form/account-form.component';


@NgModule({
  declarations: [AccountsComponent, AccountFormComponent],
  imports: [
    CommonModule,
    AccountsRoutingModule,
    SharedModule
  ]
})
export class AccountsModule { }
