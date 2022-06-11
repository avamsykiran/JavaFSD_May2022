
Application

    CLI - Command Line Interface
    Standalone GUI - Graphical User Interface
    Web Applications
        Dynamic Web Application
        Single Page Application
    
    Application = 
            persistence layer       + application layer         +    user interface / user experiecne  
             storage                    Bussiness Logic                 UI/UX

            Oracle/MySQl/MongoDB    + Java / C / C++ / C#.Net   +       html +CSS +JS + Angular/ReactJS

BackEnd - Java

    James Gosling   and team developed java

    Initially java was distributed by Sun Microsystemsm, later taken over by Oracle Corporation.

    Java Standard Edition      JSDK - Java Standard Development Kit includes Java Runtime Environment
                                All core ablities and features of java

    Java Enterprise Edition    is to develop enterprise level (Distrucuted) applications.

    Java Micro Edition          is to develop software for smart devices / IoTs ..etc

    J2SE - Java 2 Standard Edition
    ---------------------------------------------------------------

        Versioning / Evolution

            JDK 1.1
            JDK 1.2 ................................. 1.11 ...... 1.13

        Characteristics

            is generel purpose high level computer programming language
            it is a compiler and interpreter based language
            is case sensitive 
            the syntax is inspired after C and C++

        Features

            Simple
            Robust
            Distributed
            Multi-Threaded
            Self Documented
            Platform Independent
            Archetecture Neutral

            Platform Independent ?

                prog.c  ---compile on windows ----> prog.exe (binary code that window can understand)

                prog.java ---compile on windows --> prog.class (intermediate byte code and that is not understood by any OS)
                                                                    (it is understood by JVM - Java Virtual MAchine).
                
                A virtual machine is a kind of os that runs on another os.

                released a differetn native copy of JVM to each OS in the world.
                Now bbeacause every OS has JVM, and the .class file can run on any JVM, it can run on any OS.

                JDK = Java Development Kit = java class library + java tools + JRE

                JRE = JVM + JIT + Java class loader + GC

                    JVM - Java Virtual Machien on that .class file will execute
                    Java Class Loader = is to locate a class fiel and load it whenever needed.
                    JIT - Just-in-time compiler (Interpreter)
                    GC - Garbage Collector

                JDK and JRE is not platform independent
                .class files are only platorm independent

                java class library = is a collection of built-in classes provided in JSE
                java tools:
                        javac               java compiler           javac Prog.java
                        java                JIT                     java Prog.class
                        javap               java parser             javap Prog.class
                        javadoc             java documentator       javadoc Prog.java
                        jar                 java archive            
                                            pack or unpack a .jar file 


        Tokens
        


