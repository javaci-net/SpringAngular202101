import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionsComponent } from './transactions.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

const routes: Routes = [{ path: '', component: TransactionsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TransactionsRoutingModule { }
