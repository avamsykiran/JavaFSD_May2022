
class Txn{
    constructor(txnId,desp,amount,txnDate,type,holder){
        this.txnId=txnId;
        this.desp=desp;
        this.amount=amount;
        this.txnDate=txnDate;
        this.type=type;
        this.holder=holder;
    }
}

export default Txn;