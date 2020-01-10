package com.walker.tcc.service;

import com.walker.tcc.domain.FrozeRequest;
import com.walker.tcc.domain.Inventory;
import com.walker.tcc.repository.FrozeRequestRepository;
import com.walker.tcc.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@Component
public class FrozeService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private FrozeRequestRepository frozeRequestRepository;

    @Transactional(rollbackFor = Exception.class)
    public void confirm(FrozeRequest request, Inventory inventory) {
        frozeRequestRepository.delete(request);
        int left = inventory.getLeftNum() - request.getFrozenNum();
        if (left < 0) {
            throw new IllegalStateException("inventory left < 0");
        }
        inventory.setLeftNum(left);
        inventoryRepository.save(inventory);
    }

    @Transactional(rollbackFor = Exception.class)
    public void cancel(FrozeRequest request) {
        frozeRequestRepository.delete(request);
    }

}
