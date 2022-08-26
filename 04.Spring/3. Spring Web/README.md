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

     Repo(s) <--> Service(s) <--> Controller(s) <--> FrontController <--REQ--------  Clinet
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
                |-InterlResourceViewResolver
                    prefix
                    suffix

                    view = prefix + viewName + suffix

        

        @Controller
        @RequestParam
                        
        @RequestMApping(value="url",method=RequestMethod.GET)      @GetMapping("url")
        @RequestMApping(value="url",method=RequestMethod.POST)     @PostMapping("url")

