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

    Directive
        Component Directive / Component
            @Component({
                selector:'',
                templateUrl:'',
                styleSheets:[]
            })
            class MyComponent {

            }

        Attribute Directive
            @Directive({
                selector:''
            }) 
            class MyDirective {

            }

        Structural Directive
    Pipe
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

