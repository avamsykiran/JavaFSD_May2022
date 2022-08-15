Spring Ioc
-----------------------------------------------------------------------

    Spring Core
    Spring Context
    Spring SpEL
    Spring AOP


    Dependecny 

        that one software component 'A' depends on another software component 'B'
        if and only if a function of A can anot accomplish unless a function of 'B' is invoked.

        interface EmployeeDAO{

        }

        class EmployeeDAOJdbcImpl implements EmployeeDAO {

        }

        interface EmployeeService {

        }

        class EmployeeServiceImpl implements EmployeeService {
            private EmployeeDAO empDao;

            public EmployeeServiceImpl(){
                this.empDAO=new EmployeeDAOJdbcImpl();
            }


        }

    Dependency Injection

    
        interface EmployeeDAO{

        }

        class EmployeeDAOFileSystemImpl implements EmployeeDAO {

        }

        class EmployeeDAOJdbcImpl implements EmployeeDAO {

        }

        class EmployeeDAOJpaImpl implements EmployeeDAO {

        }

        interface EmployeeService {

        }

        class EmployeeServiceImpl implements EmployeeService {
            private EmployeeDAO empDao;

            public EmployeeServiceImpl(EmployeeDAO empDAO){
                this.empDAO=empDAO;
            }

            public void setEmpDAO(EmployeeDAO empDAO){
                this.empDAO=empDAO;
            }

        }

        //constructor injection
        EmployeeService empS = new EmployeeServiceImpl(new EmployeeDAOFileSystemImpl()); 
        
        //setter injection
        emps.setEmpDao(new EmployeeDAOJdbcImpl());
        

    Containers

        a container is resposnible to create,manage, supply and destroy objects of classes
        all by itself. and these contaienrs also does the dependency injection when needed.

        the objects that are managed by the container are called BEANS

        the classes whose objects are being managed by the contaienr are called COMPONENTS.

    Spring Containers

        BeansFactory        Spring Core
        ApplicationContext  Spring Context

    Spring Bean Configuration

        is to inform the spring container 
            1. how many components we have
            2. how many beans we need
            3. how are the components dependent.

        Xml based bean configuration

        Annotation based and Java based bean configuaration

            @Configuration
            @ComponenetScan("basePackage")
            public class MyBeanConfig{
                
                @Bean
                public Scanner kbin(){
                    return new Scanner(System.in);
                }

                @Bean
                public LocalDate today(){
                    return LocalDate.now();
                }
            }

            @Component("beanName")
                @Service
                @Repository

            @Autowired
                field               field injection
                constructor         constructor injection
                setter              setter injection

                by type             
                by name
                    @Qualifier

            @PropertySource
            @Value

            @Scope                  singleton       prototype














