package chat.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"chat"})
public class SpringChatServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringChatServerApp.class);
    }
}
