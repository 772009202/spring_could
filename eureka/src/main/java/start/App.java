package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class App {
    //@EnableEurekaServer 表示开启EnableEurekaServer服务
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
