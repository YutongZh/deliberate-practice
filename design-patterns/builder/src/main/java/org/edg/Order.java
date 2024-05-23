package org.edg;

/**
 * 建造器模式
 *
 * @auther zyt
 * @date 2024/5/23
 */
public class Order {

    private final Long orderId;
    private final String orderName;
    private final Integer orderType;

    public Order(OrderBuilder orderBuilder) {
        this.orderId = orderBuilder.orderId;
        this.orderName = orderBuilder.orderName;
        this.orderType = orderBuilder.orderType;
    }

    public static class OrderBuilder {
        private  Long orderId;
        private  String orderName;
        private  Integer orderType;

        public OrderBuilder orderId(Long orderId){
            this.orderId = orderId;
            return this;
        }
        public OrderBuilder orderName(String orderName){
            this.orderName = orderName;
            return this;
        }
        public OrderBuilder orderType(Integer orderType){
            this.orderType = orderType;
            return this;
        }
        public Order builder(){
            return new Order(this);
        }
    }


}
