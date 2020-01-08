package com.walker.transaction.domain.order;

import lombok.Data;

import javax.persistence.*;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/8
 */
@Data
@Entity
@PersistenceUnit(unitName = "orderPersistUnit")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userId;
    private String productCode;
    private Integer quantity;

}
