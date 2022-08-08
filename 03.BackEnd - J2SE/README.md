
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

            Identifiers
                    is a name given to any resource like varaible, object, class, fucntion ..etc.,
                    
                    Rules
                        1. an identifier can be alpha-numeric but must start with a alphabet.
                        2. an identifier cna be of any length but minimum one.
                        3. an identifier cna not have spaces or any special symbols in it but underscore(_) is allowed.
                        4. an identifer can not match with a key word.
                        5. no two resources cna have the same identifier.

                    Conventions
                        variables and methods

                            start and continue in lower case, and from second word initial capitals mst be followed.

                            height
                            boxHeight

                            display()
                            displayData()

                        classes, interfaces, annotations and enums

                            follow initial capitals all through the name.

                            Box
                            BoxWithLid
                            Exception
                            ArrayIndexOutOfBoundsException

                        constants

                            must be all caps and _ is used to seperate words.

                            LIMIT
                            MAX_LIMIT
                            MIN_LIMIT

                        packages

                            must be all lowercased and abrevated

                            io
                            util
                            lang
                            ...etc.,

            Keywords

                    reserved words in a language for some specific purpose, we ahve around 54 keywords in java.

            Operators

                    words / symbols used to represent an operation.

                    Binary Operators
                        Arthmetic      +,-,*,/,%
                        Relational     <,>,<=,>=,!=,==
                        Logical        &&,||,!
                        Assignment     =,+=,-=,*=,/=,%=

                    Unary Operators     -,++,--
                    Ternary Operator    cond ? true_exp : false_exp ;

                    Bitwise Operators       &,|,^,~,<<,>>
                    Misllinous Operators
                                ;
                                { }
                                ( )
                                < >
                                instacneof
                                .
                                ::
                                ...

            Comments            //single lien comments or line-end comments
                                /*
                                    block commnts or
                                    multi-line comments
                                */

            Literals

                hardcoded values in a source code.

                c = 2 * PI * r;

                c,r,PI are identifers
                =,*,; are operators
                2 is a literal

                Integer
                    Decimal Number System           1  18  21       1_03_45_60_892
                    Octal Number System             01  08  081
                    HexaDecimal Number System       0xA 0xF22
                Flioating Point                     3.14
                String                              "Hello "
                Character                           '$'
                Void                                null
                Boolean                             true,false

        Sample Java Program

            package in.techpinnacle.jsedemo.ui;

            class HelloWorldApp {
                public static void main(String a[]) {
                    System.out.println("Hello World! Welcome To Java");
                }
            }

        Object Oriented Programming
        -------------------------------------------------------------------

            Class And Object

                class is a user defined data type, it encapsulates
                state and behaviour as fields and methods respectively.

                class Rectangle {
                    int length;
                    int breadth;

                    int getArea(){
                        return length*breadth;
                    }

                    int getPerimeter(){
                        return 2*(length+breadth);
                    }
                }

                object is a variable of class type.

                Rectangle r; //declaration
                r = new Rectangle(); //allocation
                Rectangle r2 = new Rectangle(); //initialization
                Rectangle r3 = r;

                r.length = 56;
                r.breadth = 88;
                System.out.println(r.getArea());

            Encapsulation

                Encapsulation, also known as data hiding,
                is a concept of providing indirect access to protoect
                the state from misuse.

                Encapsulation is achived through access specifiers
                and getter,setter methods.

                Access Specifiers
                    default
                    private
                    protected
                    public

                    if a field or method is not marked with
                    any access specifier then they come under
                    default access specifier

                    or else a field or a method can be marked
                    as private or protected or public.

                    private fields or methods can be accessed
                    only within the class definition.

                    public fields or methods can be accessed
                    any where in the program.

                    class Rectangle {
                        private int length;
                        private int breadth;

                        public void setLength(int length){
                            this.length=length;
                        }

                        public int getLength(){
                            return length;
                        }

                        public void setBreadth(int breadth){
                            this.breadth=breadth;
                        }

                        public int getBreadth(){
                            return breadth;
                        }

                        public int getArea(){
                            return length*breadth;
                        }

                        public int getPerimeter(){
                            return 2*(length+breadth);
                        }
                    }
  
                Rectangle r1= new Rectangle(); 
                Rectangle r2= new Rectangle(); 

                r1.setLength(56);
                r1.setBreadth(88);
                System.out.println(r1.getArea());

                r2.setLength(156);
                r2.setBreadth(288);
                System.out.println(r2.getArea());

                'this' keyword refers to the current object of a method

                @ System.out.println(r1.getArea()); this of getArea is r1
                @ System.out.println(r2.getArea()); this of getArea is r2

                Constructor

                    is a special method that gets invoked immediatly after an object
                    gets allocated.

                    genrally cosntructors are used to pass values into the fields of an object
                    as when it is allocated.

                    constructors must have the same name as that of the class and they do not return
                    anything even not void.

                    if a class has no cosntructor defiend, then a constructor with no implementation
                    is automatically defiend in it at the tiem of compilation.

                'static' keyword

                    static fields are also called class variables and the non-static fields are called
                    instance variables. For each object of a class a seperate copy of instance variables are 
                    allocated but all the objects of a class will have the same copy of class variables.

                    static methods are used to represent common operations. The static emthods can
                    access only static members of the class directly. If static methods are public
                    they can be invoked by the class name itself.

                    static block

                        static {
                            //any java code...
                            //a class can have one and only static block
                            //the static block is executed when the class is accessed for the first time
                            //and a static block executes only once.
                        }

            Inheretence

                is the concept of defining a new data type from and exiting data type.

                the existing type is called super type
                and teh new one is called sub type.

                single          Rectangle (length,breadth) <---------- Cuboid ( height)
                multi-level     Employee (empId,name,basic) <----- Manager ( allowence) <---- Director ( share)
                heirarichial
                                                                    | <--------- ContractEmployee ( contractDuration)
                                Employee (empId,name,basic) <-----  |
                                                                    | <----------- Manager ( allowence) 

                hybrid
                                                                    | <--------- ContractEmployee ( contractDuration)
                                Employee (empId,name,basic) <-----  |
                                                                    | <----------- Manager ( allowence) <---- Director ( share)


                    1. Whenever a sub class object is allocated, the super class constructor is invoekd first followed 
                        by the sub class constructor

                    2. Super type references can hold an object of the sub type

                            Rectangle r = new Cuboid(); //it is possible , implicit type casting

                            Employee e1 = new Employee();
                            Employee e2 = new Manager();
                            Employee e3 = new ContractEmployee();
                            Manager m = new ContractEmployee(); // compilation error
                            Employee e4 = new Director();
                            Manager m1 = new Director();
                            Diector d = new Manager(); //compilation error

                            Manager mObj1 = (Manager) e1; //Runtime ClassCastException
                            Manager mObj2 = (Manager) e2; //explict type casting
                            ContractEmployee ce = (ContractEmployee) e3; //explict type casting

                    3. 'final' keyword

                        final Field or final localVariable, they end up as constants.

                                public static void main(String ..a){
                                  final String s1 = "Hello";

                                  //s1 can not hold any other value than "Hello"

                                  final Employee e = new Employee();

                                  e.setName("Vamsy"); //it is very much possible

                                  e = new Employee(); //compilaiton error as e is final   
                                }

                        final method can not be overridden

                        final class can not be inhereted any more. means we can have only 0
                        sub-classes to a final class.

            
            Polymorphisim           

                technique of having more than one methods with the same name.


                Overloading means when on what is being passed differs, how we do also differs.
                    having two or more methods in the same class or in a super and sub class
                        with the same name but different types of params or
                        different number of params or both.

                class HumanBeing {

                    public Energy eat(Apple apple){
                        Energy e = new Energy();
                        wash(apple);
                        Pieces[] pieces = cut(apple);
                        for(Piece p : pieces){
                            e.add(chewAndSwallow(p));
                        }
                        return e;
                    }

                    public Energy eat(IceCream ic){
                        Energy e = new Energy();
                        
                        while(!ic.isEmpty()){
                            e.add(lickAndSwallow(ic));
                        }
                        
                        return e;
                    }

                    public Energy eat(Meat meat){
                        Energy e = new Energy();

                        wash(meat);
                        coocked(meat);
                        
                        while(!meat.isEmpty()){
                            e.add(biteChewAndSwallow(meat));
                        }
                        
                        return e;
                    }
                }

                Constructor Overloading is having more than one constructor in the same class.And they
                muyst differ in the type or number of params.
                    default constructor             no-args
                    paramatrized constructor        has atleast one arg
                    copy constructor                has atleast one arg of the same class type.
            
                Overriding is having two or more methods in a super and a sub class
                    having the same signature but different implimentions.

                class Barbarian extends HumanBeing {

                    public Energy eat(Meat meat){
                        Energy e = new Energy();
                        
                        while(!meat.isEmpty()){
                            e.add(biteChewAndSwallow(meat));
                        }
                        
                        return e;
                    }
                }

            Abstraction

                means to hide a behaviour.

                achived in java using 'abstract' keyword

                abstract class 
                        we can not instantiate an object to that class.

                abstract class with abstract method
                        an abstract method has no implementation.
                        only abstract classes can accomidate an abstract method.

                interface
                    is a special use defined data type that can only have 
                        1. public abstract methods
                        2. public methods with implementation (default methods)
                        3. public static methods with implementation
                        4. public static final fields.

                    interfaces support multiple inheretence with classes, a single
                    class can inhereit from more than one interface


                    Human                    Animal
                      |- MasculineHuman         |-MaleAnimal
                      |- FemineHuman            |-FemaleAnimal


                    Father
                    Brother
                    Mother
                    Sister
            
            When a class happens to inhereit from an abstract class or an interface, it has ot
            override all the abstract methods.

            Enums
                    means Enumeration

                    is a user defind data type that provides a list of contant objects, each
                    representing a possible value of a field.

                    enum Gender{
                        MALE,FEMALE
                    }

                    class Employee {
                        private int empId;
                        private String fullName;
                        private Gender gender;
                    }

                    e.setGender(Gender.MALE);
                    e.setGender(Gender.FEMALE);

                    1. Each constant of an enum has an index/ordinal starting from zero
                    2. Enums can be directly converted to strings for printing ..etc.,
                    3. .valueOf(string) method is sued to convert a string into a respective enum constant
                    4. .values() that retuns an array of all constants in that enum

        Java Standard Libraries
        ---------------------------------------------------------------------------------------

            java.lang               Object,System,Math
                                    Wrapper Classes
                                    String,StringBuilder,StringBuffer
                                    Exception Handling
                                    Multi-Threading

            java.time               date time api

            java.util               Utility Classes like Random,Scanner
                                    Generics
                                    Collections
                                    Stream API and Lambda Expressions

            java.io
            java.nio                IO Streams

            java.sql
            javax.sql               JDBC

        java.lang
        ----------------------------------------------------------------------------------------

            is said to be the defualt implicit package which means that this 
            package need not be imported explicitly.

            java.lang.Object        the default super class

                                    int hashCode();
                                    boolean equals(Object); 
                                    String toString();

            java.lang.System        in  : java.io.InputStream and represents the standard input (Keyboard)
                                    out : java.io.PrintStream and represents the standard output (VDU-Monitor)
                                    err : java.io.PrintStream and represents the standard error (VDU-Monitor)

                                    void exit(int)

            java.lang.Math          offers mathematical operations

            Working With Strings

                   + Strings are immutable 
                   + StringBuffer and StringBuilder for manipulating Strings.

            Wrapper Classes

                    byte            Byte
                    short           Short
                    int             Integer
                    long            Long
                    double          Double
                    float           Float
                    char            Character
                    boolean         Boolean
                    void            Void

                Boxing refers to converting a variable into wrapper object

                    byte b = 22;
                    Byte bObj = b; //auto-boxing 

                UnBoxing referes to converting a wrapper object into a variable

                    byte b1 = bObj; //auto-unboxing

            Exception Handling

                an exception is a situation while an app is is executing where it
                encountered an unacceptable input or operation.

                when ever a exception occurs the JVM wraps that info into an exception
                obj, and the program is termianted aburptly and the exception stack-trace
                is printed.

                to handle an exception is to go for an alternate code and keep the app
                executing normally even when an exception occurs.

                java.lang.Throwable (i)
                            |
                            |- java.lang.Error
                            |
                            |- java.lang.Exception
                                            |
                                            |- java.lang.RuntimeException

                Exception class and all of its sub-classes are called CHECKED Exceptions

                RuntimeException class and all of its sub-classes are called UNCHECKED Exceptions


                Checked exceptions must be handled using a try-catch control statement. Compiler
                will not continue if it finds that checked excpetions are not handled. Whereas
                Unchecked exceptions are ignored by the compiler.

                    int[] nums = new int[10];

                    int x = -1;

                    if(x>=0 && x<nums.length) // ArrayIndexOutOfBoundsExcepiton is avoided.
                        nums[x] = 89; 

                    
                    class EmployeeService{
                        public void increasePay(Employee emp,double amount){
                            if(emp!=null)   //NullPointerException is avoided
                                emp.setSalary(emp.getSalary()+amount);
                        }
                    }

                    empService.increasePay(null,1000);

                UnchekedExceptions are expected to be avoided using defensive programing and are
                not supposed to be handled using try..catch

                Checked Exceptions can not be avoided and hence must be handled using try..catch.,

                try {
                    //that code is written which may throw an exception
                }catch(ExceptionType1 expObj){
                    //alternate code when the exception occurs.
                }catch(ExceptionType2 expObj){
                    //alternate code when the exception occurs.
                }catch(ExceptionType3 expObj){
                    //alternate code when the exception occurs.
                }finally {
                    //code that has to execute irrespective of an exception occuring or not.
                }

                try {
                    //that code is written which may throw an exception
                }catch(ExceptionType1 | ExceptionType2 | ExceptionType3 expObj){ //multi-catch block
                    //alternate code when the exception occurs.
                }finally {
                    //code that has to execute irrespective of an exception occuring or not.
                }

                'throw' and 'throws'

                    'throw' keyword is used to raise an exception programatically.

                    'throws' keyword will tranfer an exception from a method to its calling method.

                User Defiend Exceptions

                    are classes that are developed by the developere and are inheriting
                    Exception or RuntimeException class.

                java.lang.Exception

                        Exception()
                        Exception(String message)
                        Exception(Throwable throwable)            

                        getMessage()
                        printStackTrace()

        java.time
        ----------------------------------------------------------------------------------------

        Date and Time Operations

            LocalDate           .now(),.of(year,Month,day)
            LocalDateTime       .now(),.of(year,Month,day,hour,minute,second)
            ZonedDateTime       .now(zoneId)

            Period
            Duration

            DateTimeFormatter

        Generics
        ---------------------------------------------------------------------------------------

            Generic is an abstract data type or imaginary data type that is used
            to defien the algorithm and at the tiem of execution, the data types are realized.

            public class Swapper<T>{
                public void swap(T a,T b){
                    System.out.println("Before Swapping \t"+a+"\t"+b);
                    T t=a;
                    a=b;
                    b=t;
                    System.out.println("After Swapping \t"+a+"\t"+b);
                }
            }

        java.util
        ----------------------------------------------------------------------------------------
            Scanner
            Random
         
        Collections
        ----------------------------------------------------------------------------------------
            
            Collection (i)                                          Map (i)
                |   E add(E)                                            (Key,Value) pair
                |   void remove(E)                                      void put(K,V)
                |   int size()                                          v get(K)
                |   boolean isEmpty()                                   void set(K,V)
                |   Stream stream()                                     Set<K> keySet()
                |   boolean contains(E)                                 boolean containsKey(K)
                |
            ----------------------
            |                   |
            Set (i)             List (i)
                No duplicate        Duplecate elements are allowed
                Only one null       Any number of nulls can be inserted
                No Index            Index based operations are available

                                    E get(int index)
                                    E add(int index,E)
                                    E first()
                                    E last() ...etc.,


            List implementations
                Vector          is a growable array, thread safe
                ArrayList       is a growable array, not thread safe
                LinkedList      is a doubly linked list

            Set implementations
                HashSet             the retrival order is not predictable
                LinkedHashSet       the retrival order is as same as the entry order
                TreeSet             the retrival order is an sorted order

            java.lang.Comparable                    is implemented by the smae model class whose objects must be compared
                    int compareTo(E object)

            java.util.Comparator                    is implemented by any class to compare object of any model class
                    int compare(E obj1,E obj2)


            Collections         has utitlity methods to work with different collection objects.
            Arrays              has utitlity methods to work with arrays


        Multi-Layer Archetecture
        ---------------------------------------------------------------------------------------------------------

            DAO <---model----> SERVICE <---model----> UI

            DAO : Data Access Object
                    hold all the datbase operations related code - Persistence Logic

            SERVICE: hold all the validation,computation ..etc code - Bussiness Logic

            UI: hold all the input output related code to interact with the user - Presentation Logic

            Each layer is expected to have an interface and its implemnetation class.
            Where the interface serves as teh abstraction between two layers.

        Case Study - IncomeStatment
        -------------------------------------------------------------------------------------------------------

            Income Statement is a statement that catalogs all the earnings and spending
            and gives the balance left.

            To add/ remove/ retrive the transactions made by a user

        IO Streams
        ---------------------------------------------------------------------------------------------------------

            Stream menas flow of data.

            Working with Streams coming from or going to input output devices are handled by IO Streams.

            APP <--------Input -------- Device (Keyboard/Mouse/HDD)
            APP --------Output --------> Device (Monitor/Printer/HDD)

            The Stream can carry data as bits and bytes (binary)

            Binary Streams
                APP <-----byte----------- Device
                APP -----byte-----------> Device
        
            The Stream can carry data as text 

            Text Streams or Character Stream

                APP <-----chars----------- buffer <-----bytes----------- Device
                APP -----chars-----------> buffer -----bytes-----------> Device

                java.io
                    InputStream     OutputStream                Reader                  Writer
                        |               |-PrintStream               |-InputStreamReade      |-PrintWriter
                        |               |-FielOutputStream          |-BuffredReader         |-FileWriter
                        |               |-ObjectOutputStream        |-FileReader
                        |- FileInputStream
                        |- ObjectInputStream

                    IOException
                    FileNotFoundException
                    File
                    Serializable

                java.nio
                    Path
                    Files
        
        Streams API
        ---------------------------------------------------------------------------------------------------------

            Functional Interface    is an interface that has only one abstract method.

            Functional Interfcases facilate a conept called Lambda Expressions.

            A Lambda Expression is a inline implementation of an interface.


            interface MyInterface {
                T methodName(T a);
            }

            class MyInterfaceImpl implements MyInterface {
                public T methodName(T a){
                    //..our implementation code
                }
            }
        
            MyInterface obj = new MyInterfaceImpl();
            T result = obj.methodName(tValue);
            
            MyInterface obj2 = x -> {
                    //..our implementation code
            };
            T result2 = obj2.methodName(tValue2);

            java.util.function  offers a varaity of functional interfaces,
                supplier            takes no args but return a value
                consumers           takes params but returns nothing
                predicates          always returns boolean
                other functional


            java.util.stream.Stream

                Arrays.stream(array)
                listObj.stream()
                setObj.stream()

                Intermidate Streams Opertors
                            .map(operator)      returns a new Stream
                            .filter(predicate)  returns a new Stream

                Terminal Stream Operators

                            .collect(Collectors.toList())   returns a list
                            .collect(Collectors.toSet())    returns a set
                            .forEach(Consumer)              returns nothing
                            .reduce(BinaryOperator)         returns a single value

        Maven - is a build and dependency management tool
        --------------------------------------------------------------------------------------

            'make'      predomiantly designed to work with c-language applications

            'ant'       by Apache Software Foundations, is very flexible and has no project strucutre restrcitions.
                        it had no uniform build plan or build target as a result an ant build file is everytime 
                        new to a developer. it has no dependency management.

            'maven'     by Apache Software Foundations and has a very strict project structure and 
                        is a build and dependency management tool.

                        each maven project is uniquly identified by a combination of three thing 
                                'group-id' and 'artifact-id' and 'version'
                                
                                group-id generally refers to the team or organizaton that owns the project
                                artifact-id refers to the project name

                        each maven project is described by a file called 'pom.xml'
                        Project Object Model -
                            1. Project meta data
                                group-id
                                artifact-id
                                version
                                description
                                author
                                keyword ...etc

                            2. Build File Properties
                                are local build file level variables that can be used across the build file script.

                            3. Dependency List
                                the list of thrid party project (libs) we need in our project

                            4. Build Plan

                        how dependecy managment is achived?

                            Maven offers four levels of repositories where a maven repository is 
                            a store of java projects (.jar)

                            Maven Central Repository        https://mvnrepository.com/repos/central
                                it is a web site that has all the .jar files published into.

                            Maven Remote Repository
                                is a proxy reposituory maintained by a software company int its private network
                                
                            Maven Local Repository
                                '.m2' folder in the users folder of the developer machine
                                all our .jars needed are downloded here and are refered in the classpath
                                of our projects.

                            Mavne Project level Repository
                                '.jar's that are not published into maven central repo, must be
                                obtained by other means and a copy that jar is placed in any folder say 'lib'
                                inside our project folder.  That lib folder is called 'project level repo'.

                        how the build process fucntions?

                            Goals
                                a goal is a task or a build phase

                                clean
                                compile
                                test
                                build
                                ...etc

                            Plugins

                                is a maven executor for each of the goals.

                        how to use maven?

                            1. Maven is available as a tool on any IDE
                            2. Maven can be downlaoded and used through maven CLI

        JDBC - Java Database Connectivity
        --------------------------------------------------------------------------------------

            was designed to get our application connected with RDBMS (SQL based databases) .

            JDBC is a specification.

                RDBMS   <----DRIVER--->    Java APP
            
            Jdbc Drivers 
                Type 1: JDBC-ODBC Bridge driver
                Type 2: Java Native API Driver
                Type 3: Network Drivers
                Type 4: All Java Drivers

                Oracle              <---Oracle Thin Driver----->   
                Ms SQL SERVER       <---Ms Jet Driver---------->   <--JDBC api-->   Java APP
                MySQL               <-MySQL Connector/J Driver->   

            JDBC Api

                java.sql

                                Load Driver (java.lang.Class.forName("driver class name"))            
                                            (automatized in JDBC 4.0 - JDK 5)
                                                        |
                                                        ↓
                                Open a Connection - Connection con = DriverManager.getConnection(dbUrl,userId,pwd);

                                        RDBMS           dbUrl/ConnectionString
                                        Oracle          jdbc:oracle:thin:@localhost:1521:DatabaseServiceName
                                        MySQL           jdbc:mysql://localhost:3306/databaseName

                                                        |
                                                        ↓
                                -------------------------------------------------------------------
                                ↓                                   |                             |
                        Statement st = con.createStatement();       |       CallableStatement cst = con.prepareCall("");
                                                                    |
                                                                    ↓
                                                    PreparedStatement pst = con.prepareStatement("sqlQuery");

                        can be used to execute                      we have to use different PreparedStatmenet Objs
                        differetn queries with a                    for different queries to bet exeucted. But we
                        single Statement Obj                        have support for paramatrized queries.

                        int executeUpdate("DML query")              int executeUpdate();
                        boolean exeucte("DDL query")                boolean execute();
                        ResultSet exeucteQuery("select query")      ResultSet executeQuery();

                                                                    setT(paramIndex,paramValue);
                                                                    
                        SQLException
                        ResultSet

                                boolean next();
                                T getT(colIndex);
                                T getT(colLabel);
        
        Multi-Threading 
        --------------------------------------------------------------------------------------

           Process          is an active program.
           Program          is a passive process.

           Process Handling

                on invokation, the process is allocated a processId and is queued.
                Once picked up by the CPU, a heap, a stack and a program counter are allocated.
                These three are called the state of the process.
                No two processes can share of these three.
                    Heap is used as the working memory area to hold program instructions, program variables ..etc
                    Stack is used to keep track of the function calls and the function local variables.
                    Program Counter isa registry that keeps track of the instruction line number being executed as of now. 

            
            A CPU is capable of multi-processsing
            multi-processing is the responsibility of a multi-tasking operating system.
            Throgh time-slicing a processer is given multiple processes one after the other by the
            operating systema dn that appears as if the CPU is doing multi-processing only because
            the time unit in a time slice is not human detectable.

            Each tiem a processis paused and another process is given to the cpu, the prev'
            process state must be saved and the next process state must be loaded, and this is called
            context switching.

            Thread          is a process that can share its heap with other threads in a thread group.
                            and each thread will have seperate program counter and stack.

            Java is by default multi-thread, each java program is a thread inside the JVM.

            Runnable
                |           public void run();      representes the job to be executed by a thread
                |-Thread
                            Thread();
                            Thread(String name);
                            Thread(Runnable runnable);
                            Thread(String name,Runnable runnable);

                            String getName();
                            void setName(String name);
                            int getPriority();
                            void setPriority(int);

                            void start();
                            void join();

                            static Thread currentThread();
                            static void sleep(long);

                                    Thread t = new Threa(...) //instantiation
                                            |
                                            ↓
                                        t.start()
                                            ↓
                                    En-Queued - READY...  -----as and when the resocures are available->|
                                            ↑                                                        ↓
                                            PAUSED   <--------(sleep)------------------------ Execution(running)..
                                                                                                        |
                                                                                                        | once the job is done
                                                                                                        |
                                                                                                        ↓
                                                                                                    Termination

            Conccrency

                one processing unit doing multiple tasks simultanously

                T1  12 units of time
                T2  8 units of time


                U1  U2  U3  U4  U5  U6  U7  U8  U9  U10 U11 U12 U13 U14 U15 U16 U17 U18 U19 U20
                ----------------------------------------------------------------------------------------------
                T1  T1  T1  T1  T1  T1  T1  T1  T1  T1  T1  T1  T2  T2  T2  T2  T2  T2  T2  T2      sequqntial
                T2  T1  T2  T1  T2  T1  T2  T1  T2  T1  T2  T1  T2  T1  T2  T1  T1  T1  T1  T1      concurrency

                Mulktiple tasks using Runnable (tasks that wont return a value) or Callalble (tasks that can return avlaue).

                Runnable and Callable are asynchronous tasks, meaning that these taks happen concurrently and
                will not block the application flow - non-blocking units.

                We will have to wait until the asynchronous taks is finished to retrive the result,
                and that is possible using 'Future'.

                The Callables return Future to be able to chekc the status of the callable and once
                callable is complete we can retrive the vbalue from the future.

                Excutors is a untility interface tha is used to create ExecutorServices.
                Tese Executor Services can be loaded with as many tasks as we want and 
                each task is spanbned into one or more threads from a controlled 
                thread pool.

            Parellisim

                multiple processing units doing sub-tasks of a same task parellelly.
                it is possible only if we have multiple cores on your CPU

                Java supports parallisim via - Parellel Streams and Fork/Join api.

                listObj.stream()            is a sequential stream
                listObj.parellelStream()    is a parellel stream

        Testing
        --------------------------------------------------------------------------------------

            is to verify if the completed part of the product / the product is matching with the
            required design.

            Testing Methods
                Black Box       for a given input, the expected output and the actual output must match.

                White Box       is to verify if all the coding bracnhes are being executed at least once,
                                and if all coding braches are executing exactly the expected number of times
                                for a given input.
                
                Grey Box        
                
                Smoke Test      is based on the principal, "IF THERE's SMOKE THEN THERE's FIRE".

            Testing Level

                Unit Testing
                Integrated Testing
                System Testing
                Quality Analysis Testing
                User Acceptence Test
                    Alpha Test
                    Beta Test

            Test Case
                is a collection of test methods written to test one unit of code.

            Test Scenario
                is a specific input-output-expected output of a test case.

            Test Run
                is each execution of a test case.

            Test Data
                is the croup of inputs on which the test caseses have to execute.

            Test Suite
                a group of test cases - grouped for the purpose of exeucting a time.
            
            JUnit 5
                is the testing platform used most commonly for testing java products.
                this si used for unit testing and integrated testing.

                JUnit Engine
                JUnit Runner
                Junit Platform API 

            Mockito
                is sued on top of JUnit for stub testing or mocking.

            hamcrest
                is used on top Junit Platform / JUnit API for additional
                matchers.

        JUnit 5 API
        --------------------------------------------------------------------------------------

            Assertion
                    is a boolean situation which continues a program on receiving true and 
                    termintes on receiving false.

                    test case uses assertion in a way that if the assertion is success then the 
                    test case is passed or else the test case is failed.

            Assertions static class offers a variety of assert methods. These assert methods
            are used as matchers to match an actual output with an expected output.

            @Test                       to identify that a method is a test-method.
            @ParamatrizedTest           to identify that a method is a test-method.
            @DisplayName                is used to give a readable name to a test method
            @BeforeEach                 applied on a method that has to execute before each of the test case executes.
            @AfterEach                  applied on a method that has to execute after each of the test case executes.

            @Suite

        Mockito
        ----------------------------------------------------------------------------------------

            is a testing library used for mock tests otherwise called 'Stub Tests'

            ComponentA      -------------->> ComponentB

            Testing ComponentB without supplying actual ComponentA  is 'Stub Unit Test'

            Testing ComponentB with actual ComponentA  is 'Integrated Test'

        Java Evolution 8 to 11
        ----------------------------------------------------------------------------------------

            Java 8
                        Default and Static Methods in inerfaces
                        Functional Interfaces and Lambda Expressions
                        date and time api
                        regexp
                        java.nio package
                        Streams API
                        Parlellisim and Concurrency

            Java 9
                        Collections
                            Collections got a couple of new helper methods, to easily construct Lists, Sets and Maps.

                            List<String> list = List.of("one", "two", "three");
                            Set<String> set = Set.of("one", "two", "three");
                            Map<String, String> map = Map.of("foo", "one", "bar", "two");

                        Streams
                            Streams got a couple of additions, in the form of takeWhile,dropWhile,iterate methods.

                            Stream<String> stream = Stream.iterate("", s -> s + "s")
                                                    .takeWhile(s -> s.length() < 10);

                            Stream<String> stream = Stream.iterate("", s -> s + "s")
                                                    .dropWhile(s -> s.length() >= 10);
                        Interfaces
                            Interfaces got private methods:

                            public interface MyInterface {

                                private static void myPrivateMethod(){
                                    System.out.println("Yay, I am private!");
                                }
                            }
                        
                        JShell
                            Finally, Java got a shell where you can try out simple commands and get immediate results.
                        
                        Project Jigsaw: 
                            Java Modules and Multi-Release Jar Files

                        HttpClient
                            as a experimental feature
            
            Java 10
                        Local-Variable Type Inference: var-keyword                        
                            String myName = "Marco"; // Pre-Java 10
                            var myName = "Marco"; // With Java 10
                            
                        Run Source Files
                            Starting with Java 10, you can run Java source files without having to compile them first. A step towards scripting.
                            
            Java 11
                    Strings
                        "Marco".isBlank();
                        "Mar\nco".lines();

                    Files
                        Path path = Files.writeString(Files.createTempFile("helloworld", ".txt"), "Hi, my name is!");
                        
                        String s = Files.readString(path);

                    Local-Variable Type Inference (var) for lambda parameters
                        (var firstName, var lastName) -> firstName + lastName

                    HttpClient
                        is prmianant feature.

            https://www.marcobehler.com/guides/a-guide-to-java-versions-and-features

        Java Modules
        ----------------------------------------------------------------------------------------

            A Module is a group of closely related packages and resources along with a new module descriptor file.

            In other words, it's a “package of Java Packages” abstraction that allows us to make our code even more reusable.

            Each module is responsible for its resources, like media or configuration files.
            Previously we'd put all resources into the root level of our project and manually manage which resources belonged to different parts of the application. With modules, we can ship required images and XML files with the module that needs it, making our projects much easier to manage.

            A module includes a descriptor file that defines several aspects of our new module:

            Name – the name of our module
            Dependencies – a list of other modules that this module depends on
            Public Packages – a list of all packages we want accessible from outside the module
                             by default all packages are module private.
            Services Offered – we can provide service implementations that can be consumed by other modules
            Services Consumed – allows the current module to be a consumer of a service
            Reflection Permissions – explicitly allows other classes to use reflection to access the private members of a package

            module-info.java
                module.name {
                    requires name.of.the.moduel.that.the.current.module.depends.on;

                    exposes package.name.that.others.module.have.access.to;

                    provides GreetService with GreetServieTiemBasedImpl;

                    uses AServiceFromAModule;

                    opens package.name;
                }

Object Relational Mapping
--------------------------------------------------------------------------------

database <---> APP <-->  end-user

                             OOPs                                    RDBMS

EntityDef                   class                                   table
Entity                      object                                  row
Property                    field                                   column
Behaviour                   method                                  ----

Generalization              inheretence                             Single Table
    (is a)                                                              all_emps eid,fnm,sal,allw,cd
                            class Employee {
                                long empid;
                                String fullName;                    Join Table
                                double salary;                          emps    eid,fnm,sal
                            }                                           mgrs    eid,allw
                                                                        cemps   eid,cd
                            class Manager extends Employee {
                                double allowence;                   Table Per Class
                            }                                            emps   eid,fnm,sal
                                                                         mgrs   eid,fnm,sal,allw
                                                                         cemps  eid,fnm,sal,cd
                            class ContractEmployee extends Employee{
                                double contractDuration;
                            }

    (has a)
Associations
    Composition             class PersonalDetails {             emps        eid,fnm,mb,mid,fb,sal
                                String fullName                 custs       cid,fnm,mb,mid,fb
                                String email;                   vendors     vid,fnm,mb,mid,fb,stype
                                String mobile;
                                String facebook;
                            }

                            class Employee {
                                long empid;
                                PersonalDetails details;    
                                double sal;
                            }

                            class Customer {
                                long custId
                                PersonalDetails details;
                            }

                            class ServiceVendor {
                                long vendorId;
                                PersonalDetails details;
                                String serviceType;
                            }
    
    Aggregation
        OntToOne            class Employee {                        emps    eid,fnm,sal
                                long empid;                         baccs   anum,ifsc,eid
                                String fullName;                    
                                double salary;
                                BankAccount salAccount;                        
                            }

                            class BankAccount {
                                String accNum;
                                String ifsccode;
                                Employee holder;
                            }

        OneToMany           class Department {                     depts    did,dname
        ManyToOne               long deptId;                       emps     eid,fnm,sal,did
                                String dname;
                                Set<Employee> emps;
                            }

                            class Employee{
                                long empId;
                                String fullName;
                                double salary;
                                Department dept;
                            }
        
        ManyToMany          Movies   <-m2m->   Artists

                            Movies   <-o2m->   Character    <-m2o-> Artists

JPA     java persistence api        JavaEE specifications
JTA     java transaction api        JavaEE specifications

            Hibernate
            ibates ...etc.,


    JPA Annotations

        @Entity             class level
        @Table(name="")     class level
        
        @Embedable          class level

        @Inheretence            class level
        @DiscriminatorColumn    class level
        @DiscriminatorValue     class level

        @Id                 field level
        @GeneratedValue     field level

        @Column             field level
        @Transiant          field level
        
        @Enumerated         field level
        @Embeded            field level

        @OneToOne           field level
        @OneToMany          field level
        @ManyToOne          field level
        @ManyToMany         field level

        @JoinColumn         field level

    JTA Annotations

        @Transactional

    JPA API

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
        EntityManager em = emf.createEntityManger();

        em.getTransaction()
        em.persist(entity);
        em.merge(entity);
        em.remove(entity);
        em.find(Entity.class,idValue);
        em.createQuery("jpql");
        em.createQuery("jpql",ResultantClass.class);
        em.createNamedQuery("qryName",ResultantClass.class);

    Hibernate API

        SessionFactory
            Session
                beginTransaction();
                save(entity);
                merge(entity);
                delete(entity);
                query(entity);
                find(Entity.class,idValue);
                get(Entity.class,idValue);

    JPQL - Java Persistence Query Language

    SQL     select * from emps                              
    JPQL    select e from Employee e

    SQL     select full_name from emps where emp_id=?
    JPQL    select e.fullName from Employee e where e.empId=?

    SQL     select dept_name,full_name from emps inner join depts on emps.dept_id = depts.dept_id
    JPQL    select d.deptName,e.fullName fromn Employee e inner join Department d

    








