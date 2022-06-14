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
        these starter dependencies will contain the respective moduel along with 
        the minmum config....


        @SpringBootApplication  =   @Configuaration + @ComponentScan + @PropertySource + @AutoConfig

        Spring Boot Runners, are components that offer a run() method to be executed
        once teh spring boot application initiates. We can have any number of runners and the 
        runners are of a wide variety. CommandLineRunner is a common runner used to
        execute anything on a console based interface. Similarly we WebRunners ...etc.,

        Spring Tool Suite - Spring Starter Project wizard
        Spring Boot CLI
        SpringInitializr from http://start.spring.io