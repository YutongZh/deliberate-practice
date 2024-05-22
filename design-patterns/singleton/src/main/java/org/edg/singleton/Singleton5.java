package org.edg.singleton;

/**
 * 双检锁，线程安全
 *
 * 虽然经过了两次判空，保证每次只有一个线程执行new Singleton()，但还是有问题。因为instance = new Singleton()这条语句并不是原子的
 * 而是包含了三个步骤：1. 栈上分配内存空间;2. 堆上初始化对象;3. 栈上引用指向堆内存空间地址
 * instance对象用了volatile修饰，会禁止jvm对该对象的指令重排序
 *
 * @auther zyt
 * @date 2024/5/22
 */
public class Singleton5 {

    private volatile static Singleton5 instance;

    private Singleton5() {}

    public static Singleton5 getInstance(){
        if (instance == null){
            synchronized (Singleton5.class){
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
