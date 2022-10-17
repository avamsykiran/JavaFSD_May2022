Spring Web
-----------------------------------------------------------------

    is a spring frmework module that supports Web MVC applications
    and REST api applications.


    Web MVC
    
        Model View And Controller Archetecture
            Repo(s) <--> Service(s) <--> Controller(s)  <---------REQ--  Clinet
                                            |                               ↑
                                            |                               |
                                            model                           |
                                            |                               html
                                            ↓                               |
                                            View    ------RESP------------> |
            
        Single Front Controller 

            Repo(s) <--> Service(s) <--> Controller(s) <--> FrontController <--REQ--------  ClinetBROWSER) 
                                                                |                               ↑
                                                                |                               |
                                                                model                           |
                                                                |                               html
                                                                ↓                               |
                                                                View    ------RESP------------> |


        FrontController     
            1. has to receive any request from the client
            2. the request must be decoded and the collected data from the request
                is passed to an action method in a controller
            3. Once the controller is done with the processing, the controller will
                share the output data (model) and a viewName.
            5. the received model is passed to the view identified by the viewName

            DispatcherServlet   from spring web module acts as the front-controller

        Controller
            is any normal POJO class
            this class must provide methods called action methods to receive data from front controller
            belonging to a incoming request.
            and should return the model (output data) and a viewName
            
            @Controller

        View    
            is a JSP or anyother view engine that can receive model from the controller
            and render the final HTML as response.

        How will the FrontController pick up an action from a controller for each request?
            
            UrlHandler                  is an interface in spring web module
                |-SimpleUrlHandler
                    will locate the annotation @RequestMapping(value="url",method=RequestMethod.GET/POST)
                    which is applied on the action method.

        How will the FrontController pick up a View for a given viewName

            ViewResolver
                |-InternalResourceViewResolver
                    prefix
                    suffix

                    view = prefix + viewName + suffix

        @Controller
        @RequestParam
        @ModelAttribute
                        
        @RequestMApping(value="url",method=RequestMethod.GET)      @GetMapping("url")
        @RequestMApping(value="url",method=RequestMethod.POST)     @PostMapping("url")

    REST api

        is also known as RESTful WebServices.

        A webservice is a centrally hosted bussiness logic to be consumed by a variaty of ui applications.


            Persistence Tier    <------>  BackEnd       <------>    FronEnd

            database <----> WebService  <-----> UI-Application
                                                                <-----> Andriod App
            MySQL/Oralce..etc   <------>    Java WebServices    <-----> Dynamic Web App
                                                                <-----> Angular App

            Web Services
                SOAP Web Services
                    These use SOAP protocol. (Simple Object Access Protocol)

                    SOAP uses XML as medium of data-exchange.

                    SOAP can not facilitate exchange of binary date or other complicated formats.
                
                RESTful Web Service / REST api
                    these use HTTP protocol.

                    On http protocol, already we can exchange a large variety of data
                    like xml,json,binary,text,....etc.,

                    REST - REpresentational State Transfer was designed.

                    An End-point is a url mapped to a method (Bussiness Logic) to be invoked.

                        for a given resoruces let use a single end-point with varing HTTP-METHODS

                        To Work with Employees
                                                                 http-status
                                                                                     FAILUE
                    operation   end-point   http-method     SUCESS          ClientSide      ServerSide
                    ------------------------------------------------------------------------------------
                    CREATE      /emps       POST            201-CREATED     400-BAD REQUEST 500-INTERNAL SERVER ERROR
                    RETRIVE     /emps       GET             200-OK          404-NOT FOUND   500-INTERNAL SERVER ERROR
                    UPDATE      /emps       PUT             204-ACCEPTED    400-BAD REQUEST 500-INTERNAL SERVER ERROR
                    DELETE      /emps       DELETE          203-NO CONTENT  404-NOT FOUND   500-INTERNAL SERVER ERROR


                    Rest Clients are softwares used to check the working of a RESTful webservice.
                        PostMan
                        Insomnia
                        ...etc.,

                    Single Front Controller for REST api
                                                                                        (AndrioApp/AngualrApp/ReactJSAPP)
            Repo(s) <--> Service(s) <--> Controller(s) <--> FrontController <--REQ--------  Clinet 
                                                                |                               ↑
                                                                |                               | .json/.xml
                                                                model  ------RESP-------------> |

                    @RestController =   @Controller + @ResponseBody

                    @RequestMapping(url,http-method)                    
                        @GetMapping(url)
                        @PutMapping(url)
                        @PostMapping(url)
                        @DeleteMapping(url)

                    ResponseEntity  resp = new ResponseEntity(respBody,httpStatus);
    
    Spring Boot Dev Tools

        https://www.baeldung.com/spring-boot-devtools

        it is a moduel provided by spring framework to compliment the spring boot,
        by throwing a deveplopment time capabilities. Its features are

            Property Defaults
            Auto Restart
            Live Reload
            Remote Debugging
            Global Properties

            Property Defaults
                Spring boot bring a lot of auto-configuaration like for-example
                caching. it brings data caching, template caching ..etc.,
                But this caching feature is not encouriging at dev-time as we 
                have to see the changes from time to time. Thus this caching is 
                autoamtically desabled by DevTools.

            Auto Restart
                DevTools plants a monitor on the source code and as and when the
                source code is modified and saved, it trggers recompilation, packaging and
                hosting on the server and the server is auto-restarted.

            Live Reload
                DevTools has a relaod server that can trigger the browser to automatically
                reload as and when the web server restarts. And to make use of this
                the browser must install the relevant plugin.

    Swagger

        is rest api documentation tool.

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any()).build();
        }

        the documentation can be accessed through context-root/v2/api-docs

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>3.0.0</version>
        </dependency>

        the documentation-ui can be accessed through context-root/swagger-ui/

    Sprinbg boot Actuator

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        management.endpoints.web.exposure.include=*

        the actuator can be accessed through context-root/actuator/relevant-end-points

    Spring Boot Test

        is a sub-module provided by spring boot module of spring framework and provides
        the testing platform for with all neccssary inclusions like mockito and hamcrest.

Authentication and Authorization

    Authentication is to verify and confirm the identity of the user. It is done using a
    public key (userid/username/emailId/mobile...etc) and a private key (PIN/Password/OTP...etc).
    Authentication on successful verification grants entry into the app.

    anonymous user  is a user that did not log in yet.
    and authenticated user is a user whose credentials are verifeid meaning he logged in.

    Authorization is to check if the authenticated user has a privilage or not. Privileage is
    access to one or moe resources or operations. Is managed based on 'roles' like for a 
    e-commerce application ADMIN/CONSUMER/VENDOR/DELIVERY ..etc., can be roles.

Authentication is done via a large variety of machanisims.

    1. Form based Authentication
    2. Token based Authentication
        ..........etc.,

    Form Based Authentication:
        the user Identity is accepted from a html form
        and that data is securly (in encrypted form ) is brought back to the server
        and on the server the data is varified and if success then it is
        maintianed in the session on the server. As long as the user keeps
        interacting with the server, the session lives and rememebrs him as 
        authenticated. and because of this after authentiction, the upcoming
        request baring that session id are concidered authenticated.

    Token Based Authentication
        the user Identity is accepted from a html form
        and that data is securly (in encrypted form ) is brought back to the server
        and on the server the data is varified and if success then a token is generated
        and issued to the user. this token has to be submitted along with each new request.
        the token is verified every time a request comes in.

        jwt - json web token
            is one of the most common token standard used in token based authentication .

            { header.payload.signature }

CSRF    -   Cross Site  Reference Forgery

        is enabled in case of dynamic web applications
        and is disbled in case of rest-api.

Spring Security Archetecture

    UserDetails
    UserDetailsService      loadUserByUserName(....)
    AuthenticationManager
    PasswordEncoder
    HttpSecurity
    WebSecurityConfigAdapter

            https   =   http + SSL (Secured Socket Layer)
