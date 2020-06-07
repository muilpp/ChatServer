package chat.springapp;


import chat.service.CreateSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@ComponentScan(basePackages = {"chat"})
public class ChatServerApp {
    @Autowired
    static CreateSocketServer createSocketServer;

    public static void main(String[] args) {
        SpringApplication.run(ChatServerApp.class);
        System.out.println("Entro!");
        CreateSocketServer createSocketServer = new CreateSocketServer();
        createSocketServer.create();
    }
}
