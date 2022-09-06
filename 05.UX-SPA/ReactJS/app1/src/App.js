import { Component, Fragment } from 'react';
import Arth from './components/Arth';
import Header from './components/Header';

class App extends Component{
  constructor(props){
    super(props);
    this.state={
      title:"My first ReactJS SPA",
      tagLine:"...are you excited...",
      authors:["Vamsy","Srinu","Abhi"]
    };
  }

  render(){

    let {title,tagLine,authors} = this.state;

    return (
      <Fragment>
        <Header appTitle={title} appTag={tagLine} builders={authors} />
        <Arth />
      </Fragment>
    );
  }
}

export default App;
