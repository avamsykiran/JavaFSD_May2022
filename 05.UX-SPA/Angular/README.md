Angular Introduction
--------------------------------------------------------------

    is a typescript based SPA framework.

    typescript = javascript + type-safty.

    AngularJS

    Angular 2
    Angular 4
    Angular 5
    .....
    Angular 14

Angular CLI
---------------------------------------------------------------

    is a command line interface which is a frontier for creating, managing the project structure and
    for invoking execution, build, pack, and test operations on the project.

    npm install -g @angular/cli@13.3.3

    ng version

    ng new proj-name

    proj-name\> ng g module ModuleName 
    proj-name\> ng g component ComponentName  --skip-tests
    proj-name\> ng g service ServiceName  --skip-tests
    proj-name\> ng g directive DirectiveName --skip-tests
    proj-name\> ng g class ClassName --skip-tests
    proj-name\> ng g interface InterfaceName 
    
    proj-name\> ng serve --port 7878 -o
    proj-name\> ng build
    proj-name\> ng test

Angular Archetecture
------------------------------------------------------------------

    An angular app is made up of Modules, Directives, Pipes and Services.

    Each resource is a typescript class. 
    Decorators are used to mark the purpose of each class.
    Each decorator is given a json object called meta-data which holds the resource configuration.

    Module
        an angular module is different from a typescript module.
        an angular module exists on top of typescript module system.
        an angular module is a group of pipes , directives and services that repreent one unit of memory load.
        an angular module can have sub-modules as well.

        An angular project must have one and only one top-level module called ROOT MODULE.

        @NgModule({
            declarations:[],
            imports:[],
            exports:[],
            providers:[],
            bootstrap:[]
        })
        class MyModule {

        }

        declarations:[]     a list of components,directives and pipes that belong to this module
        imports:[],         a list of other modules to be imported into this module
        exports:[],         a list of components,directives and pipes that belong to this module and to be used outside
        providers:[],       a list of services that belong to this module
        bootstrap:[]        a list of components that are to be instatianted immediatly after loading this module

        'bootstrap' is found only in the ROOT MODULE, 'exports' is not found in the ROOT MODULE.

    Directive
        Component Directive / Component

            is a angular built html element.

            Component   =  Component Class + Template
                
                Component Class holds the state and behaviour as field and methods respectivly.
                Template is the DOM the component has to render.

            @Component({
                selector:'',
                templateUrl:'',
                styleUrls:[]
            })
            class MyComponent {

            }

        Attribute Directive

            is a angular built html attribute.

            @Directive({
                selector:''
            }) 
            class MyDirective {

            }

        Structural Directive

            *ngIf
            *ngFor
            ngSwitch
                *ngSwitchCase
                *ngDefault

    Pipe
        is sued to tranform a value just before it is rendered on the screen.

            lowercase
            uppercase
            titlecase
            number
            currecy
            date

        @Pipe({
            name:''
        })
        class MyPipe {

        }

    Service
        @Injectable({
            providedIn:'root'
        })
        class MyService{

        }

Data Binding
------------------------------------------------------------------

    Interpolation

        {{angular-expression}}

    Two-Way Data Binding

        is used to bind a field with a html form element.

        'ngModel' attribute directive from 'FormsModule' is used here

        <input [(ngModel)]="field" />

    One-Way Data Binding
        Attribute Binding

            <tagName attribute="value"> tagContent </tagName>
            <tagName [attribute]="fieldOrAnAngularExpression"> tagContent </tagName>

        Style Binding

            <tagName [style.cssProperty]="fieldOrAnAngularExpression"> tagContent </tagName>

        Css Class Binding

            <tagName [class]="{'class-name1':booleanField,'class-name2':booleanField2}"> tagContent </tagName>

            <tagName [class.className1]="booleanField"  > tagContent </tagName>

        Event Binding

            we bind methods with event directives.

                html event attribute            event directive

                    onSubmit                        ngSubmit
                    onClick                         click
                    onBlur                          blur
                    onFocus                         focus
                    onChange                        change
                    .....etc

            <tagName (eventDirective)="method()"> content </tagName>

Bootstrap Integration
-----------------------------------------------------------------
    npm install bootstrap --save

    angular.json
        |
        |- styles       include node_modules/bootstrap/dist/css/bootstrap.mion.css
        |- scripts      include node_modules/bootstrap/dist/js/bootstrap.min.js

Routing
-----------------------------------------------------------------

    RouterModule from '@angular/router'

        Route           {
                            path:'',
                            component:Component1,
                            pathMatch:'startsWith|full',
                            redirectTo:'',
                            children:[]
                        }

        Routes          Route[]

        router-outlet      component <router-outlet></router-outlet>

        routerLink          attribute directive for 'a' element instead of 'href'
        routerLinkActive    attribute directive for 'a' element used to apply a css class on active links

        forRoot         used to load all Routes .

        ActivatedRoute      is a service, used to extract path variable or query params from a url
        Router              is a service, used to programatically navigate from a component to another component
        
Observables - RxJS
------------------------------------------------------------------

    Observables are enhanced Promises

        Promise can emit only only value that too after the completion of the job.
        Observable can emit as many value as we want until the job is complete.

        const job = observer => {
            observer.next(val); //can be used to emit a value in due course of job execution
            observer.error(err); //can be used to raise an error in due course of job execution
            observer.complete(); //can be used to indicate the job completion.
        };

        let ob = new Observable(job);

        ob.subscribe({
            next: val => {/*catch the value and consume it*/ },
            error: err => {/*catch the err and inform th user accordingly */ },
            complete: () => {/*proceed furthur as the job is done*/ },
        })

HttpClient
------------------------------------------------------------------

    HttpClient from 'HttpClientModule' from '@angular/commons/http'

    HttpClient
        get(url) : Observable
        put(url,reqBody) : Observable
        post(url,reqBody) : Observable
        delete(url) : Observable

Angular Life Cycle Methods - Hooks
------------------------------------------------------------------

    ngOnChanges: When an input/output binding value changes.
    ngOnInit: After the first ngOnChanges.
    ngDoCheck: Developer's custom change detection.
    ngAfterContentInit: After component content initialized.
    ngAfterContentChecked: After every check of component content.
    ngAfterViewInit: After a component's views are initialized.
    ngAfterViewChecked: After every check of a component's views.ngOnDestroy: Just before the component/directive is destroyed.


Decomposing Components
------------------------------------------------------------------

Angular Forms
------------------------------------------------------------------


