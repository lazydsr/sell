package com.lazysell.sell.pojo;

import com.lazysell.sell.enums.OrderStatusEnum;
import com.lazysell.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * OrderMaster
 * PROJECT_NAME: sell
 * PACKAGE_NAME: com.lazysell.sell.pojo
 * Created by Lazy on 2017/11/11 19:20
 * Version: 0.1
 * Info: @TODO:...
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String id;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal buyerAmount;
    /**
     * 订单状态  默认为下单 0
     */
    private Integer orderStatus = OrderStatusEnum.NEW_ORDER.getCode();
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    private String createTime;
    private String updateTime;

}
