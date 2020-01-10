package com.walker.tcc;

import com.walker.tcc.domain.Inventory;
import com.walker.tcc.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.walker.tcc.repository")
public class InventoryServiceApplication implements CommandLineRunner {

    @Autowired
    private InventoryRepository inventoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Inventory inventory = Inventory.builder()
                .leftNum(100)
                .productCode("spring-cloud-in-action")
                .build();
        inventoryRepository.save(inventory);
    }
}
