package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    //@EnableFeignClients 开启Feign客户端

    //解决RestTemplate找不到  RestTemplate注册进spring容器
    @Bean
//    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
