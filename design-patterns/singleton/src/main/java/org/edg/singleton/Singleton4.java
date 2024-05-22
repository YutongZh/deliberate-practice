package org.edg.singleton;

/**
 * 双检锁模式 非线程安全
 * @auther zyt
 * @date 2024/5/22
 */
public class Singleton4 {

    private Singleton4(){}

    private static Singleton4 instance;

    public static Singleton4 getInstance(){
        if (instance == null){
            synchronized (Singleton4.class){
                if (instance == null){
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
