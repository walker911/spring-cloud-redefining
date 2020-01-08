package com.walker.transaction;

import com.walker.transaction.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistributedTransactionApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testJtaCommit() throws InterruptedException {
        try {
            orderService.newOrder("tom", "0001", 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TimeUnit.MINUTES.sleep(5);
    }

    @Test
    public void testJtaRollback() throws InterruptedException {
        try {
            orderService.newOrderRollback("tom", "0001", 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TimeUnit.MINUTES.sleep(5);
    }

}
