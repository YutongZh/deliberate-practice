package org.edg.generics;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class GenericPrinter3<T extends Vehicle & Thing>{

    private T item;

    public GenericPrinter3(T item) {
        this.item = item;
    }

    public void print() {
        System.out.println(item.getColor());
    }
}
