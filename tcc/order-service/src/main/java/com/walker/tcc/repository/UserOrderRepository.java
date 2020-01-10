package com.walker.tcc.repository;

import com.walker.tcc.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

    UserOrder findByTxId(String txId);

}
