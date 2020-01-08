package com.walker.transaction.service;

import com.walker.transaction.dao.log.EventLogDao;
import com.walker.transaction.dao.order.UserOrderDao;
import com.walker.transaction.domain.log.EventLog;
import com.walker.transaction.domain.order.UserOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/8
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final UserOrderDao userOrderDao;
    private final EventLogDao eventLogDao;

    @Transactional(rollbackFor = Exception.class)
    public void newOrder(String userId, String productCode, int quantity) {
        UserOrder userOrder = new UserOrder();
        userOrder.setUserId(userId);
        userOrder.setProductCode(productCode);
        userOrder.setQuantity(quantity);
        userOrderDao.save(userOrder);

        EventLog eventLog = new EventLog();
        eventLog.setOperation("new order");
        eventLog.setOperator(userId);
        eventLogDao.save(eventLog);
    }

    @Transactional(rollbackFor = Exception.class)
    public void newOrderRollback(String userId, String productCode, int quantity) {
        UserOrder userOrder = new UserOrder();
        userOrder.setUserId(userId);
        userOrder.setProductCode(productCode);
        userOrder.setQuantity(quantity);
        userOrderDao.save(userOrder);

        EventLog eventLog = new EventLog();
        eventLog.setOperation("new order");
        eventLog.setOperator(userId);
        eventLogDao.save(eventLog);
        throw new RuntimeException("test jta rollback");
    }
}
