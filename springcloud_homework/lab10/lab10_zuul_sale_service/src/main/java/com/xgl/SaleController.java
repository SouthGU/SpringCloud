package com.xgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sise.xgl
 * @Date: 2020/5/31/15:58
 * @Description:
 */
@RestController
public class SaleController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/sale-book/{bookId}",method = RequestMethod.GET)
    public String saleBook(@PathVariable Integer bookId){
        Book book = bookService.getBook(bookId);
        System.out.println("销售模块处理，要销售图书id："+book.getId()+",书名"+book.getName());
        return "SUCCESS";
    }

    @RequestMapping(value = "/errorTest",method = RequestMethod.GET)
    public String errorTest() throws Exception{
        Thread.sleep(3000);
        return "errorTest";
    }
}
