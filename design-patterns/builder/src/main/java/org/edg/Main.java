package org.edg;

/**
 * @auther zyt
 * @date 2024/5/23
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order.OrderBuilder()
                .orderId(1L)
                .orderName("test")
                .orderType(1).builder();

        System.out.println(order);
    }
}
