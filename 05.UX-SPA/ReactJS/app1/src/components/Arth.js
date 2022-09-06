import {Component} from 'react';

class Arth extends Component {
    constructor(props){
        super(props);
        this.state={
            op1:0,
            op2:0
        }
    }

    setOp1 = event => {
        let value = prompt("Enter a new value: ",this.state.op1);
        this.setState({op1:parseInt(value)});
    }
    
    setOp2 = event => {
        let value = prompt("Enter a new value: ",this.state.op2);
        this.setState({op2:parseInt(value)});
    }
 
    render(){
        let {op1,op2} = this.state;

        return (
            <div>
                <button type="button" onClick={this.setOp1}>Change Operand1</button>
                <button type="button" onClick={this.setOp2}>Change Operand2</button>
                <p>Sum of {op1} and {op2} is {op1+op2}</p>
                <p>Dif of {op1} and {op2} is {op1-op2}</p>
                <p>Prod of {op1} and {op2} is {op1*op2}</p>
                <p>Qut of {op1} and {op2} is {op1/op2}</p>
                <p>Rem of {op1} and {op2} is {op1%op2}</p>
            </div>
        )
    }
}

export default Arth;