package org.edg.singleton;

/**
 * 懒汉式线程安全单例模式
 * @auther zyt
 * @date 2024/5/22
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){
    }

    private static synchronized Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
