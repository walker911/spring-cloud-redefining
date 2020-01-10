package com.walker.tcc.repository;

import com.walker.tcc.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByProductCode(String productCode);
}
