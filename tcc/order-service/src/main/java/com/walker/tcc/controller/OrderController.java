package com.walker.tcc.controller;

import com.walker.tcc.TccParticipantController;
import com.walker.tcc.domain.UserOrder;
import com.walker.tcc.enums.OrderStateEnum;
import com.walker.tcc.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@RestController
@RequestMapping("/order")
public class OrderController extends TccParticipantController<UserOrder> {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public String getParticipantName() {
        return "order-service";
    }

    @Override
    public ResponseEntity executeTry(String txId, UserOrder body) {
        body.setTxId(txId);
        body.setState(OrderStateEnum.ORDERED);
        body.setExpireTime(LocalDateTime.now().plusMinutes(30));
        try {
            userOrderRepository.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @Override
    public ResponseEntity executeCancel(String txId) {
        UserOrder userOrder = userOrderRepository.findByTxId(txId);
        if (userOrder == null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        userOrder.setState(OrderStateEnum.CANCELED);
        userOrderRepository.save(userOrder);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ResponseEntity executeConfirm(String txId) {
        UserOrder userOrder = userOrderRepository.findByTxId(txId);
        if (userOrder == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        userOrder.setState(OrderStateEnum.CONFIRMED);
        userOrderRepository.save(userOrder);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
