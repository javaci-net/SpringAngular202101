import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Transactions2Component } from './transactions2.component';

const routes: Routes = [{ path: '', component: Transactions2Component }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Transactions2RoutingModule { }
