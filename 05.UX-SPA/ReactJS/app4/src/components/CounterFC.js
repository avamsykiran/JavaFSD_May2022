import { useEffect, useState } from "react";

const CounterFC = (props) => {

    let [count,setCount] = useState(0);
    let [lap,setLap] = useState(0);

    useEffect(()=>{
        setCount(1);
    },[]);

    useEffect(()=>{
        if(count===10){
            setCount(0);
            setLap(lap+1);
        }else if(count<0){
            setCount(0);
        }
    },[count]);

    const stepUp = event => {
        setCount(count+1);
    }

    const stepDown = event => {
        setCount(count-1);
    }

    return (
        <div className='p-4'>
            <button onClick={stepDown} className="btn btn-sm btn-secondary m-2"><strong>--</strong></button>
            <span>
                <strong>{count} / {lap}</strong>
            </span>
            <button onClick={stepUp} className="btn btn-sm btn-primary m-2"><strong>++</strong></button>
        </div>
    );
};

export default CounterFC;