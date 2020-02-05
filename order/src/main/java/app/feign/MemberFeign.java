package app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用feign去连接
 */
@FeignClient(name = "app-member")
public interface MemberFeign {

    @RequestMapping("/getMember")
    String getMember();
}
