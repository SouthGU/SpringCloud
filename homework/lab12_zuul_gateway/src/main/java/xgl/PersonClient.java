package xgl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/2/17:30
 * @Description:
 */
@FeignClient("dbService")
@Component
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET,value = "/stuinfo/{uid}")
    User getPerson(@PathVariable("uid") String uid);
}
