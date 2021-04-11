import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

import { AccountService } from '../account.service';

@Component({
  selector: "app-account-form",
  templateUrl: "./account-form.component.html",
  styleUrls: ["./account-form.component.css"],
})
export class AccountFormComponent implements OnInit {
  @Output() accountCreated = new EventEmitter<number>();
  accountForm: FormGroup;
  accountName = new FormControl("", [Validators.required]);
  description = new FormControl("");
  balance = new FormControl("", [
    Validators.required,
    Validators.min(0),
    Validators.max(99999),
  ]);
  currency = new FormControl("", [Validators.required]);
  status = new FormControl("ACTIVE");
  constructor(private accountService:AccountService) {
    this.accountForm = new FormGroup({
      accountName:this.accountName,
      description:this.description,
      balance:this.balance,
      currency:this.currency,
      status:this.status
    });
  }

  ngOnInit(): void {}

  handleSubmission() {
    console.log(this.accountForm.value);
    this.accountService.createAccount(this.accountForm.value)
    .subscribe(response =>{
      console.log("Res : ", response)
      this.accountCreated.emit(response)
    })
  }
}
