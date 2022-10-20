import { AccountHolder } from "./account-holder";

export interface Txn {
    txnId:number;
    desp:string;
    amount:number;
    txnDate:Date;
    type:string;
    holder?:AccountHolder;
    editable?:boolean;
}
