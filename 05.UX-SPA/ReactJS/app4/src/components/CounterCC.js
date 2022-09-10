import {Component} from 'react';

class CounterCC extends Component {
    constructor(props){
        super(props);
        this.state={
            count:0,
            lap:0
        }
    }

    componentDidMount(){
        this.setState({count:1});
    }

    stepUp = event => {
        this.setState({count:this.state.count+1})
    }

    stepDown = event => {
        this.setState({count:this.state.count-1})
    }

    componentDidUpdate(){
        if(this.state.count===10){
            this.setState({count:0,lap:this.state.lap+1});
        }else if(this.state.count<0){
            this.setState({count:0});
        }
    }

    render(){
        let {count,lap} = this.state;

        return (
            <div className='p-4'>
                <button onClick={this.stepDown} className="btn btn-sm btn-secondary m-2"><strong>--</strong></button>
                <span>
                    <strong>{count} / {lap}</strong> 
                </span>                
                <button onClick={this.stepUp} className="btn btn-sm btn-primary m-2"><strong>++</strong></button>
            </div>
        );
    }
}

export default CounterCC;