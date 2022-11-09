Microservices
--------------------------------------------------------------------------

    Monolythic Approach

        + Single Unit of deployment.
        + The applications are generally logically organised into modules.

        - modular scalability is not possible
        - interaperability on technology is not possible
        - lack of upgradability

    Microservices Approach

        + A pack (eco-system) of isolated indivudual executing applications where each app is called a Microservice.
        + Modular Scalability
        + Interaperobility is possible
        + Upgradability

        Challenges
            1. Decomposition
            2. Server addresses are dynamic due to scalability, hence difficult for inter-service communication.
            3. Database Management
            4. Request Tracing & Logging
            5. Monitoring and Profiling


    Microservice Design Patterns

        Decomposition Design Patterns
            Decompositon By doamin
            Decomposition By sub-domain
            Stangler Design Pattern

        Database Design Patterns
            Shared Database Design Pattern                  
            Per Service Database Design Pattern
            Command Querry Request Saggregation Design Pattern (CQRS)
            Saga Design Pattern

        Integration Design Pattern
            Gateway Design Pattern
            Aggregator Design Pattern
            Client Side Component Aggregation Design Pattern

        Observability Design Patterns
            Distributed Logging Design Patterns
            Distrbuted Tracing Design Patterns

        Cross-Cutting Design Patterns
            Discovery Service Design Pattern
            Load Balancing Design Pattern
            External Configuaration Design Pattern
            Circuite Breaker Design Pattern

    Monolythic IncomeStatement CaseStudy:
        1. An AccountHolder has to register
        2. An AccountHolder can update his profile
        3. An AccountHolder can add a Txn
        4. An AccountHolder can update a Txn
        5. An AccountHolder can delete a Txn
        6. An AccountHolder can retrive all of his Txns periodically
        7. An AccountHolder can retrive the statement summary

    Microservices Approach IncomeStatement CaseStudy
        Decompositon By doamin
            profile-service
                1. An AccountHolder has to register
                2. An AccountHolder can update his profile
            txns-service
                3. An AccountHolder can add a Txn
                4. An AccountHolder can update a Txn
                5. An AccountHolder can delete a Txn
                6. An AccountHolder can retrive all of his Txns periodically
            statement-service
                7. An AccountHolder can retrive the statement summary

        Decomposition By sub-domain
            profile-service
                AccountHolder (entity)
                    Long ahId,String fullName,String mobile,String mailId
            txns-service
                AccountHolder (entity)
                    Long ahId,Double currentBalance,Set<Txn> txns
                Txn (Entity)
            statement-service
                Statement     (model)
                AccountHolder (model)
                    Long ahId,String fullName,String mobile,String mailId,Double currentBalance
                Txn           (model)

        Per Service Database Design Pattern

            profile-service     <------------>      txns-service    <---------->        statement-service
                ↑↓                                       ↑↓
             profileDB                                 txnsDB

        
        Gateway Design Pattern

                Angular/React/Andriod Clients
                           ↑↓ 
                    gateway-service
                     localhost:9999
                (spring cloud api gateway)
                          ↑↓
                ----------------------------------------------------------------------------------
                ↑↓                                      ↑↓                                      ↑↓
            profile-service     <------------>      txns-service    <---------->        statement-service
             localhost:9101                        localhost:9201                         localhost:9301  
                ↑↓                                       ↑↓
             profileDB                                 txnsDB


        Distributed Logging Design Patterns & Distrbuted Tracing Design Patterns

                Angular/React/Andriod Clients
                           ↑↓ 
                    gateway-service
                     localhost:9999
                (spring cloud api gateway)
                          ↑↓
                ----------------------------------------------------------------------------------
                ↑↓                                      ↑↓                                      ↑↓
            profile-service     <------------>      txns-service    <---------->        statement-service
             localhost:9101                        localhost:9201                         localhost:9301  
                ↑↓                                       ↑↓
             profileDB                                 txnsDB
                   sleuth                                  sleuth                                  sleuth
                  zipkin-client                         zipkin-client                           zipkin-client    
                    ↑↓                                      ↑↓                                      ↑↓
                    ----------------------------------------------------------------------------------
                           ↑↓ 
                    tracing-service
                    (zipkin-server)

        Discovery Service Design Pattern
        
                Angular/React/Andriod Clients
                           ↑↓ 
                    gateway-service         <-------------------------------->  discovery-service
                    localhost:9999                                               localhost:9000
                (spring cloud api gateway)                                    (netflix eureka discovery service)
                          ↑↓                                                            ↑↓
                ----------------------------------------------------------------------------------
                ↑↓                                      ↑↓                                      ↑↓
            profile-service     <------------>      txns-service    <---------->        statement-service
             localhost:9101                        localhost:9201                         localhost:9301  
             localhost:9102                        localhost:9202
             localhost:9103
                ↑↓                                       ↑↓
             profileDB                                 txnsDB
                   sleuth                                  sleuth                                  sleuth
                  zipkin-client                         zipkin-client                           zipkin-client    
                    ↑↓                                      ↑↓                                      ↑↓
                    ----------------------------------------------------------------------------------
                           ↑↓ 
                    tracing-service
                    (zipkin-server)

        Load Balancing Design Pattern
        
                Angular/React/Andriod Clients
                           ↑↓ 
                    gateway-service         <-------------------------------->  discovery-service
                    localhost:9999                                               localhost:9000
                (spring cloud api gateway)                                    (netflix eureka discovery service)
                          ↑↓                                                            ↑↓
                ----------------------------------------------------------------------------------
                ↑↓                                      ↑↓                                      ↑↓
            profile-service     <------------>      txns-service    <---------->        statement-service
             localhost:9101                        localhost:9201                         localhost:9301  
             localhost:9102                        localhost:9202
             localhost:9103
                ↑↓                                       ↑↓
             profileDB                                 txnsDB
                spring cloud load balancer              spring cloud load balancer              spring cloud load balancer
                   sleuth                                  sleuth                                  sleuth
                  zipkin-client                         zipkin-client                           zipkin-client    
                    ↑↓                                      ↑↓                                      ↑↓
                    ----------------------------------------------------------------------------------
                           ↑↓ 
                    tracing-service
                    (zipkin-server)
        
        External Configuaration Design Pattern

                Angular/React/Andriod Clients
                           ↑↓ 
                    gateway-service         <-------------------------------->  discovery-service
                    localhost:9999                                               localhost:9000
                (spring cloud api gateway)                                    (netflix eureka discovery service)
                          ↑↓                                                            ↑↓
                ----------------------------------------------------------------------------------
                ↑↓                                      ↑↓                                      ↑↓
            profile-service     <------------>      txns-service    <---------->        statement-service
             localhost:9101                        localhost:9201                         localhost:9301  
             localhost:9102                        localhost:9202
             localhost:9103
                ↑↓                                       ↑↓
             profileDB                                 txnsDB
                spring cloud load balancer              spring cloud load balancer              spring cloud load balancer
                   sleuth                                  sleuth                                  sleuth
                  zipkin-client                         zipkin-client                           zipkin-client    
                    ↑↓                                      ↑↓                                      ↑↓
                    ----------------------------------------------------------------------------------
                           ↑↓                                                             ↑↓ 
                    tracing-service                                                     config-service
                    (zipkin-server)                                                   (spring cloud config server)
                                                                                        ↑↓ 
                                                                                        GitRepo
                                                                                            profile.properties
                                                                                            txns.properties
                                                                                            stateemnt.properties
                                                                                            gateway.properties

    Implementing Budget-tracker
                                            
        Step#1  implementing decomposed services and do inter-service communication and aggregator
            in.bta:bta-profiles
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                    mysq1:mysql-connector-java
                    org.springframework.boot:spring-boot-starter-data-jpa
                configuaration
                    spring.application.name=profiles
                    server.port=9100

                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                    spring.datasource.username=root
                    spring.datasource.password=root
                    spring.datasource.url=jdbc:mysql://localhost:3306/bapsDB?createDatabaseIfNotExist=true
                    spring.jpa.hibernate.ddl-auto=update

            in.bta:bta-txns
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                    mysq1:mysql-connector-java
                    org.springframework.boot:spring-boot-starter-data-jpa
                configuaration
                    spring.application.name=txns
                    server.port=9200

                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                    spring.datasource.username=root
                    spring.datasource.password=root
                    spring.datasource.url=jdbc:mysql://localhost:3306/batxnsDB?createDatabaseIfNotExist=true
                    spring.jpa.hibernate.ddl-auto=update

            in.bta:bta-statement
                dependencies
                    org.springframework.boot:spring-boot-starter-web
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-openfeign
                configuaration
                    spring.application.name=statement
                    server.port=9300

        Step#2  implementing discovery service and client side load balancing
            in.bta:bta-discovery
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-server
                configuaration
                    @EnableEurekaServer    on Application class

                    spring.application.name=discovery
                    server.port=9000

                    eureka.instance.hostname=localhost
                    eureka.client.registerWithEureka=false
                    eureka.client.fetchRegistry=false
                    eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
                    eureka.server.waitTimeInMsWhenSyncEmpty=0

            in.bta:bta-profiles
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false

            in.bta:bta-txns
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false

            in.bta:bta-statement
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    ++ org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    ++@EnableDiscoveryClient  on Application class

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.loadbalancer.ribbon.enabled=false    

        Step 3: Implement API Gateway Design Pattern
            in.bta:bta-gateway
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-starter-api-gateway
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                    org.springframework.cloud:spring-cloud-starter-loadbalancer
                configuaration
                    @EnableDiscoveryClient          on Application class

                    spring.application.name=gateway
                    server.port=9999

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.instance.prefer-ip-address=true
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5

                    spring.cloud.gateway.discovery.locator.enabled=true
                    spring.cloud.gateway.discovery.locator.lower-case-service-id=true
                    
            in.bta:bta-discovery
            in.bta:bta-profiles
            in.bta:bta-txns
            in.bta:bta-statement
                  
        Step 4: Implement Distributed Tracing Design Pattern
              in.bta:bta-discovery
              
              in.bta:bta-gateway
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*
           
            in.bta:bta-profiles
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            in.bta:bta-txns
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            in.bta:bta-statement
                dependencies
                    ++org.springframework.boot:spring-boot-starter-actuator
                    ++org.springframework.cloud:spring-cloud-starter-sleuth
                    ++org.springframework.cloud:spring-cloud-starter-zipkin : 2.2.8.RELEASE
                
                configuaration
                    logger.level.org.springramework.web=debug
                    management.endpoints.web.exposure.include=*

            tracing-service
                zipkin-server
                    https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec 
                    
                    java -jar zipkin-server.jar

        Step 5: Implement Circuit Breaker Design Pattern
            in.bta:bta-discovery  
            in.bta:bta-gateway
            in.bta:bta-profiles
            in.bta:bta-txns
                dependencies
                    ++org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j
                
                configuaration
                    resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInClosedState=4
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInHalfOpenState=2
                    resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
                    resilience4j.circuitbreaker.configs.default.waitDurationInOpenState= 20s
                    resilience4j.circuitbreaker.configs.default.failureRateThreshold= 50
                    resilience4j.circuitbreaker.configs.default.eventConsumerBufferSize= 10

            in.bta:bta-statement
               dependencies
                    ++org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j
                
                configuaration
                    resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInClosedState=4
                    resilience4j.circuitbreaker.configs.default.ringBufferSizeInHalfOpenState=2
                    resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
                    resilience4j.circuitbreaker.configs.default.waitDurationInOpenState= 20s
                    resilience4j.circuitbreaker.configs.default.failureRateThreshold= 50
                    resilience4j.circuitbreaker.configs.default.eventConsumerBufferSize= 10

        Step 6: External Configuaration Design Pattern
            inTheWorkSpace> md bt-props-repo
                //and then create these files in this directory
                    // gateway.properties
                    // profiles.properties
                    // txns.properties
                    // statement.properties
                    // move the content of 'application.properties' of each microservice into these respective files
                    
                inTheWorkSpace> cd bt-props-repo
                inTheWorkSpace\bt-props-repo> git init           
                inTheWorkSpace\bt-props-repo> git add .
                inTheWorkSpace\bt-props-repo> git commit -m "all service properties"
            
            in.bta:bta-discovery
            in.bta:bta-config
                dependencies
                    org.springframework.boot:spring-boot-devtools
                    org.springframework.cloud:spring-cloud-config-server
                    org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
                
                configuaration  
                    @EnableDiscoveryClient
                    @EnableConfigServer             on Application class

                    spring.application.name=config
                    server.port=9090

                    spring.cloud.config.server.git.uri=file:///local/git/repo/path

                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/
                    eureka.client.initialInstanceInfoReplicationIntervalSeconds=5
                    eureka.client.registryFetchIntervalSeconds=5
                    eureka.instance.leaseRenewalIntervalInSeconds=5
                    eureka.instance.leaseExpirationDurationInSeconds=5
            
            in.bta:bta-gateway
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=gateway
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/                    
            
            in.bta:bta-profiles
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=profiles
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            in.bta:bta-txns
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=txns
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            in.bta:bta-statement
                dependencies
                    ++ org.springframework.cloud:spring-cloud-starter-bootstrap
                    ++ org.springframework.cloud:spring-cloud-config-client

                configuaration - bootstrap.properties
                    spring.cloud.config.name=statement
                    spring.cloud.config.discovery.service-id=config
                    spring.cloud.config.discovery.enabled=true
                    
                    eureka.client.serviceUrl.defaultZone=http://localhost:9000/eureka/   

            