package com.edg.reflection;

/**
 * @auther zyt
 * @date 2024/5/13
 */
public class Consumer {

    private String name;
    private int age;
    private String sex;


    public Consumer(){
    }

    public Consumer(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Say
    public void sayHello(){
        System.out.println("hello");
    }

    @Say
    public void sayHi(){
        System.out.println("hi");
    }
}
