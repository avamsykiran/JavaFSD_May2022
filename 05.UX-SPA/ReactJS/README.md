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

        DOM is the tree representation of an html document.
        each element of the html document happens to be a node in the DOM tree.
        using javascript one can remove a node or create a new node and add it to the tree, and
        se call that as DOM manipulation.

        Now as React has to generate and modify the DOM everytime the state changes, it is
        a very time taking and heavy task. Particualrly when arrays are involved. This comes
        to be a performence dragging issue, because the DOM tree has to be modified and
        the ui on the browser must be corrected accordingly.

        React is going to maintain a parellel copy of the actual DOM called shadow DOM or
        virutal dom. now when ever the state changes the shadow DOM is regenerated, as it is
        not linked with browser ui directly it is slightly easier to modify.

        Once shadow is generated, it is compared with the actual DOM,
        node by node and only those nodes missing in the Shadow DOM are
        removed from actual DOM and those nodes missing in the actual DOM
        are added to it. And the nodes that are not matching are updated
        in the actual DOM.

        To make the coparision easier , partiucularly in case of arrays,
        each element is given a unique identification called 'key'.

    Integrating Bootstrap with React
    -----------------------------------------------------------------

        npm install bootstrap --save

        import its .css and .js into our index.js file.

    
    ReactJS Forms
    -----------------------------------------------------------------

        Controlled Component
            html elements and component state will have a single source of truth

            the data in the html element is monitored and controlled directly by component
            state.

        UnControlled Component
            html elements will have their own source.

            compoentn state and html elements values are not bound.

            the html form elements can be accessed whenever needed in the component
            through 'ref's. Where each ref is a reference variable an html eleemnt.

    Component LifeCycle Methods - (Class Components)
    ----------------------------------------------------------------

    constructor()
     |
     ↓
    render()
     |
     ↓
    componentDidMount()
            |
            ↓
        /**********************************************************
         as along the regular user interaction if any event occurs
            invoking any event handling that again invoking
            'setState'
        ************************************************************/
        |                                               ↑
        ↓                                               |
        render()                                        |
        |                                               |
        ↓                                               |
        componentDidupdate() ---------------------------|
                                |
                                ↓
        /* ***********************************************
            the above repeats until the component is unmounted
            and jsut before the unmounting...
        **************************************************/
                                |
                                ↓
                    componentWillUnmount()

    React Hooks
    -------------------------------------------------------------------

        A reac hook is a function provided react api to empower
        functional components on par with class components.

        as we know functional component are state-less, and
        functional components have no access to life-cycle methods.

        useState            is a hook that provides state for a functional component

                            returns a reader and writer for each field.
                            the reader is used to read the value of the field and
                            writer is used to update the value of the field. The
                            entier component function re-executes each tiem the writer is invoked.

                let [field,setField] = useState(initalValue);

        useEffect           is a hook that provides componentDidMount and componentDidUpadate

            useEffect(callBack)
            useEffect(callBack,[])
            useEffect(callBack,[field1,field2,....])

                            useEffect takes the callBack method to be executed
                            as componentDidMount or componentDidUpdate. it also
                            takes an array as second arg and is called dependencies.

                            when dependencies is absent the callBack
                            is equal to componentDidUpdate and componentDidMount,
                            as a result it gets executed for the first time befor rendering
                            after every tiem the render happens.

                            when dependencies is empty the callBack
                            is equal to componentDidMount,
                            as a result it gets executed for the first time befor rendering
                            
                            when dependencies is not absent and not empty the callBack
                            is equal to componentDidUpdate with a condition
                            as a result it gets executed after every render provided
                            the value of any field in the dependency array changes.

                            useEffect cna be used as many number of time as we want
                            in a component.

    AXIOS
    ------------------------------------------------------

        Ayschronous XML Input Output System

        is a library used to send and recive data from web-services

        axios.get(url)               returns Promise
        axios.post(url,reqBody)      returns Promise
        axios.put(url,reqBody)       returns Promise
        axios.delete(url)            returns Promise

        npm install axios --save
        
    Centralizewd State Management - redux
    --------------------------------------------------------------------------

        redux is a state management library used a variety of SPA frameworks.

        react-redxu is a intergration libary to integrate redux with react.

        npm install redux react-redux --save

        redux
            store       an app ideally has one and only store
                        and a store holds all the state.

            reducer     is a pure function that manages the store or
                        that operates on the store or that modifies
                        the state in the store

                        const reducer = (oldState,action) => {
                            //...code to tranform oldState into modifiedState
                            return modifiedState;
                        }

            action      is an object that guides the reducer of what operation needs to be done
                        on the state.

                        { type:'',payload:any }

                        type        indicates the operation like add/delete/update....etc
                        payload     carries data needed for the operation

            createStore used to create a store.

        react-redux (also known as connect library)
            
            Provider    is a in-built component used wrap a store around the 
                        top-level component of our app.

                        const myStore = createStore(myReducer);

                        <Provider store={myStore}>
                            <App />
                        </Provider>

            dispatch    is a method used by a component to send an action to
                        a reducer.

            connect     is a method that returns a high order component.

                        const hoc = connect(mapStateToProps,mapDispatchToProps);
                        const modifiedComponent = hoc(MyComponent);

                        mapStateToProps     is a function that is used to
                                            retrive a portion of the state
                                            and provide it as props to
                                            the component

                        mapDispatchToProps  is a function that is used to
                                            map dispatch calls of needed actions
                                            to the props of a component.

                        useSelector         is a hook used instead of mapStateToProps
                        useDispatch         is a hook that returns 'dispatch' method.

                                 useSelector / 
            store   ----------- mapStateToProps ---------
             ↑  |                                       ↓            
             |  |                                   Component1      
             |  |                                       |
             |  |                                       |
             |  |                                       |
             |  |                                   dispatch(action) via mapDispatchToProps / useDispatch
             |  |------(old state)--|                   |
             |                      ↓                   |
             |-(modified state)--reducer←----(action)---|
            
    redux-thunk (a middle ware used to integrate axios with redux)
    ----------------------------------------------------------------------

        thunk means a function that returns another function.

        When we use redux-thunk as a middleware between redux and react app,
            it provides a possibility that an action can be an object or a function.

            and when action is a fucntion then it houses async calls.

            store   ----------- useSelector -------------------------------------
             ↑  |                                       ↓                       ↓            
             |  |                                   Component1                Component2
             |  |                                       |                       |
             |  |                                       |                       |
             |  |                                       |                       |
             |  |                                   dispatch(actionObj)     dispatch(actionFunction)
             |  |                                   via useDispatch           via useDisptach
             |  |------(old state)--|                   |                       |
             |                      ↓                   |                   --------actionFunction-------------------
             |-(modified state)--reducer←|-(actionObj)--|                   |                                       |       
                                         |-(waitActionObj)←-----------------| dispatch a waitActionObj              |
                                         |                                  | axios calls are made                  |
                                         |                                  |  we will get                          |
                                         |-(dataActionObj)←-----------------|   either data, dispatch dataActionObj |
                                         |-(errActionObj) ←-----------------|   or err, dispatch errActionObj       |
                                                                            |                                       |
                                                                            -----------------------------------------
            
            applyMiddleWare function is used to apply 'thunk' on the store.


    Routing
    ----------------------------------------------------------------------

    npm install react-router-dom --save

         react-router-dom v5

                    <Link to="targetPath"> Link Text </Link>

                    <BrowserRouter>
                        <Component1 />
                        <Component2 />  //will appear as common page layout

                        <Route path="/home" component="C4" />
                        <Route path="/about" component="C5" />
                        <Route path="/contact" component="C6" />

                    </BrowserRouter>

                    <BrowserRouter>
                        <Component1 />
                        <Component2 />  //will appear as common page layout

                        <Switch>
                            <Route path="/" exact component="C3" />
                            <Route path="/home" component="C4" />
                            <Route path="/about" component="C5" />
                            <Route path="/contact" component="C6" />
                        </Switch>
                    </BrowserRouter>
                    
                    <Redirect to="targetUrl" />

            react-router-dom v6

                            <Link to="targetPath"> Link Text </Link>

                            <BrowserRouter>
                                <Component1 />
                                <Component2 />  //will appear as common page layout

                                <Routes>
                                    <Route path="/" element="C3" />
                                    <Route path="/home" element="C4" />
                                    <Route path="/about" element="C5" />
                                    <Route path="/contact" element="C6" />
                                </Routes>
                            </BrowserRouter>
                            
                            <Redirect to="targetUrl" />    

    Testing
    --------------------------------------------

        JEST is a javascript testing library.

        npm i -D --exact jest-watch-typeahead@0.6.5

        npm test        to execute test cases.