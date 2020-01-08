package com.walker.transaction.domain.log;

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
@PersistenceUnit(unitName = "logPersistUnit")
public class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String operation;
    private String operator;

}
