package com.service;

import com.entity.Product;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/11:09
 * @Description:
 */
public interface ProductService {

    /**
     * 根据id查询
     */
    Product findById(Long id);

    /**
     * 保存
     */
    void save(Product product);
    /**
     * 更新
     */
    void update(Product product);
    /**
     * 删除
     */
    void delete(Long id);
}
