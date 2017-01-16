# System to automate the place lunch choose.
## Technologies:   
* JEE7 (JSF 2.2, EJB 3.2, javax.mail, JPA 2.1)    
* jasypt   
* Wildfly 10   
* Bootstrap   
* PostgreSQL 9.5.5    
* Maven   
* Netbeans 8.2 Development Version  
* [JPA Persistence file here](https://github.com/heronsanches/dstest/blob/master/Lunch/src/main/resources/META-INF/persistence.xml)  
* [Database files here](https://github.com/heronsanches/dstest/tree/master/database)  
* [User and password to make login from it backup are: hr.sanches@gmail.com and dbserveradmin](https://github.com/heronsanches/dstest/blob/master/database/pg_dump_full.sql)

### What do you can highlight up about the system? 
1. Database was modeled to support n enterprises.
2. It was created indexes accord to the necessity of the system.
3. MVC model.
4. Low coupling from database code.
4. Login criptography (jasypt).
5. Dependence Injection between ManagedBeans, SessionBeans-ManagedBeans, SessionBeans-SessionBeans
6. The care at think and plan the system.
7. Fine Integration between Bootstrap, HTML5, JSF and Javascript. 
6. Google Maps API

### What would you made to enhancement your system?

1. It would be created a EJB module separeted, but them are implementing local interfaces, so it can be desacopled without more problems and deployed a part of the .war into the same JVM.
2. Implementing the searchbar function.
2. Continuation of the scheduling system, implementing rules that turn them totaly automaticaly.
2. Development into TDD world. 

![Login](https://github.com/heronsanches/dstest/blob/master/screens/login.png "Login")
![Lunch](https://github.com/heronsanches/dstest/blob/master/screens/lunch.png "Login")
![Lunch](https://github.com/heronsanches/dstest/blob/master/screens/map.png "Login")
