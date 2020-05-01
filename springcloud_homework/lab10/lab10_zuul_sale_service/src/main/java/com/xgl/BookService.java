package com.xgl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:45
 * @Description:
 */
@FeignClient("zuul-book-service")
public interface BookService {
    /**
     * 调用书本服务的接口，获取一个Book实例
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/book/{bookId}")
    Book getBook(@PathVariable("bookId") Integer bookId);
}
