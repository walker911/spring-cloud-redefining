package com.walker.tcc.controller;

import com.walker.tcc.TccParticipantController;
import com.walker.tcc.domain.FrozeRequest;
import com.walker.tcc.domain.Inventory;
import com.walker.tcc.repository.FrozeRequestRepository;
import com.walker.tcc.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController extends TccParticipantController<FrozeRequest> {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private FrozeRequestRepository frozeRequestRepository;

    @Override
    public String getParticipantName() {
        return "inventory-service";
    }

    @Override
    public ResponseEntity executeTry(String txId, FrozeRequest body) {
        Inventory inventory = inventoryRepository.findByProductCode(body.getProductCode());
        if (inventory == null) {
            return ResponseEntity.notFound().build();
        }
        if (inventory.getLeftNum() < body.getFrozenNum()) {
            return ResponseEntity.notFound().build();
        }
        body.setTxId(txId);
        try {
            frozeRequestRepository.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @Override
    public ResponseEntity executeCancel(String txId) {
        Optional<FrozeRequest> optional = frozeRequestRepository.findById(txId);
        if (!optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        FrozeRequest frozeRequest = optional.get();
        Inventory inventory = inventoryRepository.findByProductCode(frozeRequest.getProductCode());
        if (inventory == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ResponseEntity executeConfirm(String txId) {
        Optional<FrozeRequest> optional = frozeRequestRepository.findById(txId);
        if (!optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        FrozeRequest frozeRequest = optional.get();
        Inventory inventory = inventoryRepository.findByProductCode(frozeRequest.getProductCode());
        if (inventory == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
