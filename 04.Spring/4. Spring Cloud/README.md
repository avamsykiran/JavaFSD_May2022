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

        Chalenges
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

