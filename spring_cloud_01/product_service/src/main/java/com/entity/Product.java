package com.entity;

/**
 * @Auther: sise.xgl
 * @Date: 2020/3/16/11:02
 * @Description:
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品实体类
 */
@Data
@Entity
@Table(name="tb_product")
public class Product {

    @Id
    private Long id;
    private String productName;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private Integer inventory;
}