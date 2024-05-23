package org.edg;

import lombok.Builder;
import lombok.Data;

/**
 * @author yutong
 * @date 2024/5/23
 */

@Data
@Builder
public class OrderA {

    private  Long orderId;
    private  String orderName;
    private  Integer orderType;
}
