
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

                Construcotr Overloading is having more than one constructor in the same class.And they
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