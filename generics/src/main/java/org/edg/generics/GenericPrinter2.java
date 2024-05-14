package org.edg.generics;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class GenericPrinter2<K, T>{

    private K item1;
    private T item2;

    public GenericPrinter2(K item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }


    public void print(){
        System.out.println(item1);
        System.out.println(item2);
    }
}
