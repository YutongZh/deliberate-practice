package org.edg.generics;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class Car extends Vehicle implements Thing{


    public Car(String color) {
        super(color);
    }

    public void run(){
        System.out.println("car run");
    }

    public void doSomething() {

    }
}
