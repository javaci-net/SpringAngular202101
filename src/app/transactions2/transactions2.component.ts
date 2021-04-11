import {Component, OnInit} from '@angular/core';
import {Transactions2Service} from "./transactions2.service";
import {ITransaction} from "../shared/models/dto";

@Component({
    selector: 'app-transactions2',
    templateUrl: './transactions2.component.html',
    styleUrls: ['./transactions2.component.css']
})
export class Transactions2Component implements OnInit {

  transactions:Array<ITransaction> = [];
  showForm = true;
    constructor(private transactionService: Transactions2Service) {
    }

    ngOnInit(): void {
        this.getTransactions()
    }

    getTransactions() {
     this.transactionService.getTransactions()
         .subscribe(_res => {
           console.log("transactions" , _res)
           this.transactions = _res
         })
    }

    showTransactionForm() {
        this.showForm =!this.showForm
    }
}
