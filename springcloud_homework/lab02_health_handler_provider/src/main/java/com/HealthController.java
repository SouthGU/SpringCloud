package com;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/19:46
 * @Description:
 */
@RestController
public class HealthController {
    static Boolean canVisitDb = false;

    @RequestMapping(value = "/db/{canVisitDb}",method = RequestMethod.GET)
    public String setConnectState(@PathVariable("canVisitDb") boolean canVisitDb){
        HealthController.canVisitDb = canVisitDb;
        System.out.println("==============="+HealthController.canVisitDb);
        return "Now database is state:"+HealthController.canVisitDb;
    }

}
