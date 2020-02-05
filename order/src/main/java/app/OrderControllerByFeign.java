package app;


import app.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerByFeign {

    @Autowired
    private MemberFeign memberFeign;

    @RequestMapping("/getOrderByFeign")
    public String getOrder() {
        return memberFeign.getMember();
    }
}
