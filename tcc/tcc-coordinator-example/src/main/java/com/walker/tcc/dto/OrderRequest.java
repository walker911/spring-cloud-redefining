package com.walker.tcc.dto;

import lombok.Builder;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/10
 */
@Data
@Builder
public class OrderRequest {

    private String userId;
    private String productCode;
    private Integer quantity;

}
