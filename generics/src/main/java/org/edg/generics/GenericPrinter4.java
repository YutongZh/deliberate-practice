package org.edg.generics;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class GenericPrinter4{
    public <T> void print(T item){
        System.out.println(item);
    }


    public <T extends Vehicle & Thing> void print2(T item){
        System.out.println(item);
    }


    public <T> void print2(T item){
        System.out.println(item);
    }

}
