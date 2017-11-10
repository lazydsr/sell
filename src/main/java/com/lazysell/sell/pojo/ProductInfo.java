package com.lazysell.sell.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * ProductInfo
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.pojo
 * Created by Lazy on 2017/11/10 12:28
 * Version: 0.1
 * Info: @TODO:...
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
    private String id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品库存
     */
    private Integer productStock;
    /**
     * 商品描述
     */
    private String productDesc;
    /**
     * 商品图标  -小图
     */
    private String priductIcon;
    /**
     * 商品状态
     */
    private Integer productStatus;
    /**
     * 商品类目编号
     */
    private Integer categoryNum;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

}
