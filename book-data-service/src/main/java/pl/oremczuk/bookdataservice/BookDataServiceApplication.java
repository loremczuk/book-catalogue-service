package pl.oremczuk.bookdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookDataServiceApplication.class, args);
    }

}
