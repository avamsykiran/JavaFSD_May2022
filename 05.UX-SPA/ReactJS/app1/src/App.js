import { Component } from 'react';

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
      <header>
        <h3>
          {title} <br />
          <small>{tagLine}</small>
        </h3>
        <h4>Team</h4>
        <ol>
          {authors.map(a => (<li>{a}</li>))}
        </ol>
      </header>
    );
  }
}

export default App;
