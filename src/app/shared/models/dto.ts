export enum Currency{
    TL='TL' , USD="USD", EURO='EURO', GOLD='GOLD'
}
export enum UserStatuses{
    UNAPPROVED ='UNAPPROVED', ACTIVE='ACTIVE', INACTIVE='INACTIVE'
}

export enum TransactionTypes{
    EXCHANGE='EXCHANGE' , TRANSFER="TRANSFER", WITHDRAW="WITHDRAW"
}

export interface IAccount{
    accountName: string,
    description?: string,
    balance: number ,
    currency:Currency ,
    status: string,
    id: number,
    accountNumber: string
}

export interface IUser{
    citizenNumber:number,
    firstName:string,
    middleName?:string,
    lastName?:string,
    birthDate:string,
    email:string,
    phoneNumber:number
    status?:UserStatuses
    id: number
}

export interface ITransaction{

    id:number,
    toAccountId: number,
    toCustomerName: string,
    description: string,
    amount: number,
    type: TransactionTypes
}

export interface ILoginSchema{
    username:string,
    password:string
}

export interface IInformation{
    type:string,
    message:string
}
