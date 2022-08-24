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

            CrudRepository  (i)
                |- JpaRepository (i)
                        Optional<Entity> findById(id)
                        List<Entity> findAll()
                        Entity save(entity)
                        void deleteById(id)
                        boolean existsById(id)

            public interface EmployeeRepo extends JpaRepository<Employee,Long> {

            }

