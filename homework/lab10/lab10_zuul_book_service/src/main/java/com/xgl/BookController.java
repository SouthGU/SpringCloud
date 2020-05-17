package com.xgl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:35
 * @Description:
 */
@RestController
public class BookController {
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable Integer bookId){
        Book book = new Book();
        book.setId(bookId);
        book.setName("微服务");
        book.setAuthor("xgl");
        return book;
    }
}
