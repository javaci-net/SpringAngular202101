import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Transactions2RoutingModule } from './transactions2-routing.module';
import { Transactions2Component } from './transactions2.component';
import {SharedModule} from "../shared/shared.module";
import { TransactionFormComponent } from './transaction-form/transaction-form.component';


@NgModule({
  declarations: [Transactions2Component, TransactionFormComponent],
  imports: [
    CommonModule,
    Transactions2RoutingModule,
      SharedModule
  ]
})
export class Transactions2Module { }
