Web Evolution
----------------------------------------------------

    static web site

        is a folder having pre-written .html pages, hosted on
        a http-server otherwise called a web-server.

    dynamic web applications

        Server Side                                                         Client (Browser)
         
         server side executing      <----------REQ-----------------------
         programs (servlets/jsp/    
         asp/asp.net/php/           as per the req,
         spring controllers)        a specfic program 
                                    is invoked adn that
                                    will generate 'html content'
                                    dynamically.

                                    ---------(html content) RESP----------> the html content is received,
                                                                            the prev content is unloaded
                                                                            and the new html content is
                                                                            loaded.

    single page applications

        Server Side                                                         Client (Browser)
         
            spa-bundle              <--------First REQ---------------------
            (index.html + .js)
                                    -----spa-bundle (RESP)----------------->    the index.html oade 
                                                                              is loaded and its assosiated
                                                                              javascript code is also loaded
                                                                              on to the browser.

                                                                              From now on the javascript code will
                                                                              take charge of the application flow.

                                                                              all event -handling and content management'
                                                                              is going to happen on the client maschine, no
                                                                              more server contact needed.

                                                                              the new html-content is generated dynamically
                                                                              on the client side itself and this generated
                                                                              content will replace the differential parts
                                                                              on the index.html and no more loading or reloading.

            rest-api            <---------------------REQ------------------     the javascript here if need data
                                --------------.xml/.json RESP-------------> the data is received by the javascript code
                                                                            and new html content for this data is generated
                                                                            on the client and is rendered on the index.html.

ReactJS 
--------------------------------------------------------------------
    React JAvascript is a javascript library for building SPA's.

    Lab Setup
    ----------
    VSCode
    NodeJS
    Browser


    Why NodeJS?

        we create a javascript application
        
        1. compoe the code                IDE          VSCode
        2. test the code                  testing tool jest
        3. manage dependencies            build tool   npm
        4. package our project            packaging    webpack

        jest, npm, webpacka are javascript tools that neede to be executed on the 
        developer machine. And hence on the developer to support the execution of these
        tools we need NodeJS.

    create-react-app       is a tool used to generate standad project structure for react applications

    npm install -g create-react-app
    create-react-app app-name

    or

    npx create-react-app app-name

    npm start
    npm test
    npm build

    ReactJS Components
    ------------------------

        a component is a reusble piece of code that represents 
        a user defined html element.

        Component = state + behaviour + props + template

            state       is the data that the component has to maintain

                EmpRegistrationComponent    employee details are state
                ShoppingCartComponent       list of items ate the state ...etc
            
            behavour    is the methods used to handle the events.

            template    is teh html dom to be rendered for this component.

            props       is short for properties , each of which represents an attribute
                        for the component tag. These attributes can be used to share data
                        across components.

        Class Components

            a component is created using a javascript class.

            class MyComponent extends React.Component {
                constructor(props){
                    super(props);
                    //state initialization
                    this.state = {};
                }

                render(){
                    return singleJsxElement; //is the template of this component.
                }
            }

            JSX     Javascript eXtended.

                is an amulgamation of javascript + html
                we can write javascript code inside { } and embed it
                in html.

                in javascript

                    let title = "some title";

                    let h3Obj = docuemnt.createElement("h3");
                    if(title) {
                        h3Obj.textContent = title;
                    } else{
                        h3Obj.textContent = "No title";
                    }
                    

                    let authors = ["Vamsy","Srinu","Abhishek"];
                    let olObj = document.createElement("ol");

                    for(let a of authors){
                        let liObj = document.createElement("li");
                        liObj.textContent = a;
                        olObj.append(liObj);
                    }                    


                in JSX

                    let title = "some title";
                    //let h3Obj = <h3>{title && title} {!title && "No title"}</h3>
                    let h3Obj = <h3>{title ? title : "No title"}</h3>

                    let authors = ["Vamsy","Srinu","Abhishek"];
                    let olObj = (
                        <ol>
                         {authors.map(a => <li>{a}</li>)}
                        </ol>
                    );

                JSX Rules
                    1. html elements are always lower cased. 
                        <header>
                        </header>
                    2. React Components are Init-Capitalized.
                        <Header>
                        </Header>
                    3. 'class' attribute is not allowed, 'className' is to be used instaed.

        Function Components

            is a javascript function that accepts the props and returns a singleJSXElement.
            these are also known as state-less components.

            const MyComponent2 = props => (singleJSXElement);

        High Order Components

            is a javascript function that accepts a component and returns a component.

            const hoc1 = component1 => component2;

    ReactJS Component state
    --------------------------------------------------

        'state' is a field in Component class.
        'state' is initialized in the component constructor.

        'state' is always monitored by an observer and each time the state changes,
        the 'render()' is invoked to update the DOM.

        'state' is immutable. The 'state' is expected to be replaced always using
        'setState' method.

        'setState(partialStateObj)' is not expected to be called in 'render()'.

        
    ReactJS Shadow DOM / Virtuial DOM
    ---------------------------------------------------