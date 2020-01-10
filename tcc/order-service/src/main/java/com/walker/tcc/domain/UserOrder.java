package com.walker.tcc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.walker.tcc.enums.OrderStateEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "user_order", uniqueConstraints = {@UniqueConstraint(name = "idx_tx_id", columnNames = {"txId"})})
@EntityListeners(AuditingEntityListener.class)
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String txId;
    private String userId;
    private String productCode;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private OrderStateEnum state;
    private LocalDateTime expireTime;
    @Version
    private Long version;
    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
