package org.edg.generics;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class StringPrinter {
    private String item;
    public StringPrinter(String item) {
        this.item = item;
    }

    public void print() {
        System.out.println(item);
    }
}
