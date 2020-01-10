package com.walker.tcc.controller;

import com.atomikos.icatch.tcc.rest.CoordinatorImp;
import com.atomikos.tcc.rest.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/9
 */
@Slf4j
@RestController
@RequestMapping(value = "/coordinator", consumes = "application/tcc+json")
public class TccCoordinatorController {

    CoordinatorImp coordinatorImp = new CoordinatorImp();

    @PutMapping(path = "/confirm")
    public ResponseEntity confirm(@RequestBody Transaction transaction) {
        try {
            coordinatorImp.confirm(transaction);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/cancel")
    public ResponseEntity cancel(@RequestBody Transaction transaction) {
        try {
            coordinatorImp.cancel(transaction);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
    }

}
