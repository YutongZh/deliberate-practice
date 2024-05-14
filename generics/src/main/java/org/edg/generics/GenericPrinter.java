package org.edg.generics;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class GenericPrinter <T>{

    private T item;

    public GenericPrinter(T item) {
        this.item = item;
    }

    public void print() {
        System.out.println(item);
    }

}
