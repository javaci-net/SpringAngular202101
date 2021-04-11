import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Transactions2Service} from "../transactions2.service";

@Component({
    selector: 'app-transaction-form',
    templateUrl: './transaction-form.component.html',
    styleUrls: ['./transaction-form.component.css']
})
export class TransactionFormComponent implements OnInit {

    accountId = new FormControl("", [Validators.required, Validators.min(0)])
    amount = new FormControl("", [Validators.required, Validators.min(0)])
    transactionForm: FormGroup
    toAccountNumber: FormControl;
    transactionType = 'transfer';
    errorMessage = ""

    constructor(private transactionService: Transactions2Service) {
        this.transactionForm = new FormGroup({
            accountId: this.accountId,
            amount: this.amount
        })
    }

    ngOnInit(): void {
        if (this.transactionType == 'transfer') {
            this.toAccountNumber = new FormControl("", [Validators.required])
            this.transactionForm.addControl('toAccountNumber', this.toAccountNumber)
        }

    }

    transactionTypeChanged(currentValue) {
        if (currentValue == 'transfer') {
            if (!this.transactionForm.contains('toAccountNumber')) {
                this.transactionForm.addControl('toAccountNumber', this.toAccountNumber)
            }
        } else {
            if (this.transactionForm.contains('toAccountNumber')) {
                this.transactionForm.removeControl('toAccountNumber')
            }
        }
        console.log("current : ", currentValue)
    }

    handleForm() {
        this.errorMessage = '';
        console.log("Form : ", this.transactionForm.value)
        if (this.transactionType == 'transfer') {
            this.transactionService.doTransfer(this.transactionForm.value)
                .subscribe(_res => {
                    console.log("Transfer initiated!")
                    this.transactionForm.reset()
                })
        }

        if (this.transactionType == 'withdraw') {
            this.transactionService.doWithdraw(this.transactionForm.value)
                .subscribe((_res) => this.handleSuccess(_res)
                    ,
                    (error => this.handleErrors(error))
                )
        }
        if (this.transactionType == 'deposit') {
            this.transactionService.doDeposit(this.transactionForm.value)
                .subscribe((res) => {
                    console.log("deposit initiated!")
                    this.transactionForm.reset()
                }, (err) => {
                    console.log("Error : ", err.data)
                })
        }

    }

    handleErrors(err) {

        this.errorMessage = err.error.message
        console.log("Error : ", err)

    }

    handleSuccess(_res) {
        console.log("deposit initiated!")
        this.transactionForm.reset()
    }
}
