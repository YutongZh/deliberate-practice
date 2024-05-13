package com.edg.reflection;


public class Order {

    private Address address;
    private Consumer consumer;


    @Autowired
    public Order(Address address, Consumer consumer) {
        this.address = address;
        this.consumer = consumer;
    }


    public Address getAddress() {
        return address;
    }
}
