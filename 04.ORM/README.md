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


    
