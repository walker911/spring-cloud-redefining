package com.walker.tcc;

import com.walker.tcc.dto.OrderRequest;
import com.walker.tcc.service.TccOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TccCoordinatorExampleApplicationTests {

    @Autowired
    private TccOrderService tccOrderService;

    @Test
    public void testTccOrder() {
        String txId = UUID.randomUUID().toString();
        OrderRequest orderRequest = OrderRequest.builder().userId("test").productCode("spring-cloud-in-action")
                .quantity(10).build();
        tccOrderService.newOrderWithTcc(orderRequest, txId);
    }

    @Test
    public void testTccOrderRetry() {
        String txId = "02dcb1bf-8958-46b1-8f94-75ebf0eed7f9";
        OrderRequest orderRequest = OrderRequest.builder().userId("test").productCode("spring-cloud-in-action")
                .quantity(10).build();
        tccOrderService.newOrderWithTcc(orderRequest, txId);
    }

    @Test
    public void testTccOrderRollback() {
        String txId = UUID.randomUUID().toString();
        OrderRequest orderRequest = OrderRequest.builder().userId("test").productCode("spring-cloud-in-action")
                .quantity(999).build();
        tccOrderService.newOrderWithTcc(orderRequest, txId);
    }

}
