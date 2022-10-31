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
            Single Database Design Pattern
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

            