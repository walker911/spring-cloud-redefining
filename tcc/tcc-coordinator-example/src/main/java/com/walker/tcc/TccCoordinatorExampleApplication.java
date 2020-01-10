package com.walker.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@SpringBootApplication
public class TccCoordinatorExampleApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TccCoordinatorExampleApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

}
