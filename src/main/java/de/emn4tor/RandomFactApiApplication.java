package de.emn4tor;

import de.emn4tor.managers.database.DatabaseBridge;
import de.emn4tor.testing.TestMethods;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RandomFactApiApplication {

    public static void main(String[] args) {
        System.out.println("Hello from Spring Boot!");
        SpringApplication.run(RandomFactApiApplication.class, args);
        DatabaseBridge.initialize();
        new TestMethods().NewAPIKey(1, 10);



    }



}
