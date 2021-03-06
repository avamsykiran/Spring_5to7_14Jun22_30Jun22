Spring Web, REST on Spring Boot
--------------------------------------------------------------------

    Pre-Requisite
        JDK 8
        Spring Core, SpEL, Spring Context

    Lab Setup
        JDK 8
        MySQL 8 or above
        STS 4 or above

    Spring Boot

        is a spring framework module that offers RapidApplicationDevelopment
        through AutoConfiguaration and through EmbededServewrs, it offers
        server-less applications

        Spring Boot Projects are calle dSpring Starter Projects, and
        Spring Boot offers starter-dependencies for each and every spring module,
        these starter dependencies will contain the respective module along with 
        the minmum config....


        @SpringBootApplication  =   @Configuaration + @ComponentScan + @PropertySource + @AutoConfig

        Spring Boot Runners, are components that offer a run() method to be executed
        once teh spring boot application initiates. We can have any number of runners and the 
        runners are of a wide variety. CommandLineRunner is a common runner used to
        execute anything on a console based interface. Similarly we WebRunners ...etc.,

        Spring Tool Suite - Spring Starter Project wizard
        Spring Boot CLI
        SpringInitializr from http://start.spring.io

    Spring Data JPA

        is a spring framework module that offer dynamic implementation to 
        repositories.

        CrudRepository
            | - JpaRepository

        @Entity
        @Table(name=emps)
        class Employee {
            @Id
            @GeenratedValue(strategy=AUTO)
            private Long empId;
            private String empName;
            private String emailId;
            private Double salary;
            private LocalDate joinDate;

            //constructors, getters and setters...
        }

        public interface EmployeeRepo extends JpaRepository<Employee,Long> {
            
            boolean existsByEmailId(String emailId);
            Optional<Employee> findByEmailId(String emailId);
            List<Employee> findAllByEmpName(String empName);

            @Query("SELECT e FROM Employee WHERE e.salary BETWEEN :lb AND :ub")
            List<Employee> getEmployeesEarningInTheRange(Double lb,Double ub);
        }

        EmployeeRepo ::
            Employee save(Employee entity);
            boolean existsById(Long id);
            Optional<Employee> findById(Long id)
            List<Employee> findAll()
            void deleteById(Long id)

    CaseStudy - TaskManager
    --------------------------------------

        is a single user console based application to record and manage the tasks
        to be done by a user:

            A task is a record attibuted by taskId,taskDescription,assignedDate and status (PENDING/DONE)

            Requirement are 
                able to add a task
                retrive all tasks
                retrive all pending tasks
                retrive all completed tasks
                change the status of a task
            
    Spring Web

        is a spring framework module that can be used on a MVC archetecure to 
        develop either a web application or a rest api

        Dynamic Web MVC Application using Spring Web

            Single Front Controller MVC Design Pattern

              Repos <----> Services <----> Controllers <--model-- FrontController <---Reqeust-- Client
                                                |           (urlResolver)  | |
                                                |                          | |
                                                |------Model & ViewName -->| |
                                                              (ViewResolver) |
                                                                             ??? (model)
                                                                            View (s) -----Response--->

            FrontController         DispatcherServlet       Dispatcher Servlket config is automated as on Spring Boot

            UrlResolver
                BeanNameUrlResolver
                ControllerNameUrlResolver
                SimpleUrlResolver           is picked by auto-configuration of Spring Boot

                        @RequestMapping(value={"","",""},method=RequestMethod.GET/POST/....)
                            @GetMapping
                            @PostMapping
                            ...............

            ViewResolver
                MessageBeanResourceViewResolver
                XmlResourceViewResolver
                InternalResourceViewResolver        is picked by auto-configuration of Spring Boot

                        prefix
                        suffix

                        actualview = prefix + viewName + suffix

            
            Controller          is a POJO marked with @Controller.
                                the controller houses method that handle an incoming request and those methods are called actions.
                                each action is expected to be marked with @RequestMapping or its sub-types
                                each action is expected to return a viewName as a String or an object of ModelAndView class.


            Views               JSP / Thymeleaf
                                                        
            QueryString         @RequestParam

            FormData            @RequestParam
                                @ModelAttribute

        Rest-API Application using Spring Web

            WebService

                bussiness logic mounted on a server so that different UI appolication
                can invoek that bussienss logic from remote ditrubuted system.

                SOAP - Simple Object Access Protocol
                        xml as media of exchange

                REST API - REpresentational State Transfer

                        the rest api operates on http protocol,
                      
                        + http protocol is already a proven protocol that supports a vide
                            variaty of data formats including numbers and string, binary data, iamges and other media ..etc

                        + http protocol already support a variety of 'request http methods' like
                            get,put,post,trace,...etc.,

                            these methods were exploited and mapped to each CRUD operation that brought
                            doen the need for a large number of urls representing different crud operations.

                            Retriving   /emps   GET
                            Inserting   /emps   POST
                            Updating    /emps   PUT
                            Deleteing   /emps   DELETE

                        + http protocol already support a HTTP STATUS system to indicate the status of
                            the request and response.

                            this status system is also adopted to provided proper feedback for
                            each incoming request


                            100-199     to indicate that a request is recived and is under process
                            300-399     to indicate that a resposne is being redirected for different reasons

                            200-299     to indicate that a request is processed successfully.
                                            GET is success means retrival is sucessful & is indicated by 200-OK
                                            POST is success means insertion is sucessful & is indicated by 201-CREATED
                                            PUT is success means updation is sucessful & is indicated by 202-ACCEPTED
                                            DELETE is success means deletion is sucessful & is indicated by 204-NO CONTENT
                            
                            400-499     to indiacate the the request could not be processed due to an issue from the client
                                            GET is failed means retrival fails and is indicted by 404-NOT FOUND
                                            DELETE is failed means deletion fails and is indicted by 404-NOT FOUND
                                            POST is fialed means insertion fails and is indicated by 400-BAD REQUEST
                                            PUT is fialed means updatation fails and is indicated by 400-BAD REQUEST

                            500-599     to indiacate the the request could not be processed due to an issue from the server

                                            for any reson like bugs or exceptions that occur and due to which
                                            the request could not be processed we call it a server side issue
                                            and is indicated by 500-INTERNAL_SERVER_ERROR
                                      
                    @RestController     =   @Controller + @ResponseBody

                    REST Application    =   MVC - V = (No Views, Only models and controllers)

                    Rest Clients are software used to check the rest-api
                        Postman
                        Insomnia ..etc.,

                    

Case Study: Inventory Management Portal
-------------------------------------------------------------

    Navigation Bar we will have three links
        Home        for home page (ideally an empty page for landing)
        Items       Display the list of items page with detials (itemCode,itemName,unitOfMeasure,rate,stock)
        New ITem    Displaya form to add a new itme and once the form is submitted 
                    the item has to be added and the 'list of items page' must appear

            on each item row we need a link to edit tiem, delete itme and manage stock

            'manage stock' will take us to stock-page having the below details

                txnId,party name,stock in,stock out

            'mange stock' page we need a form to add a stock transaction.

    




