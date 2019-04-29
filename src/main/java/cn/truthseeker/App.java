package cn.truthseeker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication
@ImportResource(locations = {"spring.xml"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}