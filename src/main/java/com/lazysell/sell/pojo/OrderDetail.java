package com.lazysell.sell.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderDetail
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.pojo
 * Created by Lazy on 2017/11/11 19:34
 * Version: 0.1
 * Info: @TODO:...
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {
    @Id
    private String id;
    private String orderId;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIcon;
    private Date createTime;
    private Date updateTime;

}
