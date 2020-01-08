package com.walker.transaction.dao.order;

import com.walker.transaction.domain.order.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/8
 */
public interface UserOrderDao extends JpaRepository<UserOrder, Integer> {
}
