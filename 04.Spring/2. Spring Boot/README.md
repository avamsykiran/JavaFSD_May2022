Spring Boot
-------------------------------------------------------------

    is a spring framework module that offers auto-configuration there by
    providing RAD - Rapid Application Development.

        Spring Core             DI,IoC
        Spring Context          Autowiring and Lifecycle management
        Spring SpEL             Spring Expression Language

                configure he bean config class, the property source file
                ..etc.,

        Spring AOP              Aspect Oriented Programming
            configre the AOP provider ..etc.,

        Spring Web              Web MVC and Web Rest API support
            configure url-handler, view-resolver, front-controller ...etc.,

        and so on for every spring moduel we need a few setting to do called
        configuration.

        And here is where the spring boot automates the configs.. for
        any spring module.

        Spring Boot Application also called Spring Starter Proejct can be
        created in three way:
            1. using Spring Boot CLI
            2. using https://start.spring.io web-tool
            3. using STS Spring Starter Project Wizard

        @SpringBootApplication = @Configuration
                                 @ComponentScan("thePakcageInWhichTheCurrentClassExists")
                                 @PropertySource("classpath:application.properties")

            @SpringBootApplication
            public class SpringBootIocDemoApplication {

                public static void main(String[] args) {
                    SpringApplication.run(SpringBootIocDemoApplication.class, args);
                }

            }

        SpringApplication.run
                1. Create an ApplicationContext
                2. Execute all Spring runners if any
                3. Start up the embeded server if any
                4. destroys the ApplicationContext

        Spring Boot Runners
            CommandLineRunner       void run(String args[])
            ApplicationRunner       void run(ApplictionArgs args)

Spring Data
---------------------------------------------------------------

    is a module of spring framework intended to provide
    data base operations support.

        Spring Data JDBC
            JdbcTemplate
            NamedJdbcTemplate

        Spring Data JPA

            it is going provide dynamic repository implementation.

            spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
            spring.datasource.username=root
            spring.datasource.password=root
            spring.datasource.url=jdbc:mysql://localhost:3306/txndb
            spring.jpa.hibernate.ddl-auto=update

            CrudRepository  (i)
                |- JpaRepository (i)
                        Optional<Entity> findById(id)
                        List<Entity> findAll()
                        Entity save(entity)
                        void deleteById(id)
                        boolean existsById(id)

            @Entity
            @Table(name="emps")
            class Employee{
                @Id
                private Long empId;
                private String fullName;
                private Double salary;
                private String mailId;
                private LocalDate joinDate;

                /*..................*/
            }

            public interface EmployeeRepo extends JpaRepository<Employee,Long> {
                List<Employee> findAllByFullName(string fullName);
                boolean existsByMailId(String mailId);
                Optional<Employee> findByMailId(String mailId);

                @Query("SELECT e FROM Employee e WHERE e.joinDate BETWEEN :start AND :end")
                List<Employee> findAllJoinedBetween(LocalDate start,LocalDate end);
            }

        Spring Data MongoDB

            spring.data.mongodb.host=localhost
            spring.data.mongodb.port=27017
            spring.data.mongodb.database=app1

            @Document(collection = "domain")
            @Id

             CrudRepository  (i)
                |- MongoRepository (i)
                        Optional<Entity> findById(id)
                        List<Entity> findAll()
                        Entity save(entity)
                        void deleteById(id)
                        boolean existsById(id)
            

            public interface EmployeeRepo extends MongoRepository<Employee,Long> {
                List<Employee> findAllByFullName(string fullName);
                boolean existsByMailId(String mailId);
                Optional<Employee> findByMailId(String mailId);

                @Query("{$and:[{$gte:{"joinDate":start}},{"$lte":{"joinDate":end}}]}")
                List<Employee> findAllJoinedBetween(LocalDate start,LocalDate end);
            }

Spring AOP
--------------------------------------------------------------

    Aspect Oriented Programming

        eCommerce
                        Logging  Authentication TransactionManagement
            InventoryRepo       InventryService     InventoryUI
            OrdersRepo          OrdersService       OrderUI

        hrManagment
                        Logging  Authentication TransactionManagement
            DepartmentRepo      DepartmentService   DepartmentUI
            EmployeeRepo        EmployeeService     EmployeeUI

    we need to execute a method 'A'  before/after another method 'B'.

    method 'A'      comes from Aspect
    method 'B'      comes from App

    Aspect      is a plan of executing an independent operation
                when a app-logic is invoked
    
    Advice      defines 'when' should the aspect be invoked.

                    aspectj
                @Before
                @After
                @AfterReturning
                @AfterThrowing
                @Around

    JoinPoint   method 'B' is called a join point.

    PointCut    is an expression that selects a suitable join point from
                all possible join points in an application.
    
                "execution(returnType base.package.name.className.methodName(params))"

        <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<scope>compile</scope>
		</dependency>