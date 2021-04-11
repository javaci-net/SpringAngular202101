import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { InformationService } from '../shared/information.service';
import { IAccount } from '../shared/models/dto';
import { AccountService } from './account.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {
  accounts: Array<IAccount> = [];
  addAccount =false;
  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
    this.getAccounts();
  
  }
  getAccounts() {
    this.accountService.getAccounts()
    .subscribe(_accounts => this.accounts = _accounts)
  }

  toggleAccountForm(){
    this.addAccount = !this.addAccount
    
  }

  accountCreated(){
   this.getAccounts()
   this.addAccount = false;
  }

  closeAccount(accountId:number){

    this.accountService.closeAccount(accountId)
    .subscribe(_closedAccount =>{
      console.log(_closedAccount)
     for (const account of this.accounts) {
       if (account.id == accountId) {
         account.status = _closedAccount.status
       }
     }
    })
  }

}
