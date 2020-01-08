package com.walker.transaction.dao.log;

import com.walker.transaction.domain.log.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/8
 */
public interface EventLogDao extends JpaRepository<EventLog, Integer> {
}
