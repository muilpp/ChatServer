package chat.springapp;

import chat.service.OpenSocketConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@ComponentScan(basePackages = {"chat"})
public class ChatServerApp {
    private static final Logger LOGGER = Logger.getLogger(ChatServerApp.class.getName());

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(ChatServerApp.class);

        ApplicationContext context = springApp.run(args);
        OpenSocketConnection openServerSocket = context.getBean(OpenSocketConnection.class);
        openServerSocket.open();
    }
}