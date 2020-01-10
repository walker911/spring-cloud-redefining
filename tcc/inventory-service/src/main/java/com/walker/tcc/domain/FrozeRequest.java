package com.walker.tcc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
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
@SQLDelete(sql = "update froze_request set deleted = 1 where tx_id = ? and version = ?")
@Where(clause = "deleted = 0")
@EntityListeners(AuditingEntityListener.class)
public class FrozeRequest {

    @Id
    private String txId;
    @Column(name = "deleted")
    private Integer deleted = 0;
    private String productCode;
    private Integer frozenNum;
    @Version
    private Long version;
    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
