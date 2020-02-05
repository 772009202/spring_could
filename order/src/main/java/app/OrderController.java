package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    //web组件提供的 rest底层就是httpclient 默认整合ribbon负载均衡器
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 请求总数
     */
    private int countRequest = 1;

    /**
     * 在springboot中有两种调用方式：rest、fegin（springcloud）
     */
    @RequestMapping("/getOrder")
    public String getOrder() {
        //这里restTemplate的调用方式有两种  一种是直接调用不走eureka 一种是使用别名
        //LoadBalanced才能使用别名
        String url = "http://app-member/getMember";

//        String url = getUrl() + "/getMember";
        String result =
                restTemplate.getForObject(url, String.class);
        System.out.println("结果:" + result);

        return result;
    }

    /**
     * 实现动态负载均衡 也就是ribbon做的事情
     * @return
     */
    private String getUrl() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("app-member");
        if (serviceInstances == null || serviceInstances.size() <= 0) {
            return null;
        }
        //有多少生产者集群
        int size = serviceInstances.size();
        int t = countRequest % size;
        countRequest ++;
        return serviceInstances.get(t).getUri().toString();
    }
}
