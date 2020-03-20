package com;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/19/19:47
 * @Description:
 */
@Component
public class MyHealthIndicator {

        public Health health(){
            if (HealthController.canVisitDb){
                return new Health.Builder(Status.UP).build();
            }else {
                return new Health.Builder(Status.DOWN).build();
            }
        }

}
