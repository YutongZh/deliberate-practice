package com.edg.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 主类
 *
 * @auther zyt
 * @date 2024/5/13
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Container container = new Container();
        container.init();
        Class<?> clazz = Class.forName("com.edg.reflection.Order");
        Object instance = container.createInstance(clazz);
        Field field = clazz.getDeclaredField("consumer");
        //私有属性设置访问权限
        field.setAccessible(true);
        Object obj = field.get(instance);
        Class<?> aClass = obj.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getAnnotation(Say.class) != null){
                declaredMethod.invoke(obj);
            }
        }
    }
}
