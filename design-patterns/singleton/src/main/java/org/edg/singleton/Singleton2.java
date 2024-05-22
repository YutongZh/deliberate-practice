package org.edg.singleton;

/**
 * 懒汉式非线程安全单例模式
 * @author yutong
 * @date 2024/5/22
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
