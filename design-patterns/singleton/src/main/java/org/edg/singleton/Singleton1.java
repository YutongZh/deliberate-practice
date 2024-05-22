package org.edg.singleton;

/**
 * 饿汉式单例模式(线程安全的)
 *
 * @author yutong
 * @date 2024/5/22
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
