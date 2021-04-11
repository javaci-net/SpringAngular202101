import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ITransaction } from '../shared/models/dto';
import { TransactionService } from './transaction.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  $transactions : Observable<Array<ITransaction>>;
  constructor(private transactionService:TransactionService) { }

  ngOnInit(): void {
    this.$transactions = this.transactionService.getTransactions()
  }

}
