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
                                                                             ↓ (model)
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