package com.edg.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 容器类
 *
 * @auther zyt
 * @date 2024/5/13
 */
public class Container {

    private Map<Class<?>, Method> methodMap;
    private Object config;
    private Map<Class<?>, Object> serviceMap;

    /**
     * 容器初始化
     *
     * @author zyt
     * @date 2024/5/13 16:24
     */
    public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.methodMap = new HashMap<Class<?>, Method>();
        this.serviceMap = new HashMap<Class<?>, Object>();
        Class<?> clazz = Class.forName("com.edg.reflection.Config");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getAnnotation(Bean.class) != null){
                methodMap.put(method.getReturnType(), method);
            }
        }
        this.config = clazz.getConstructor().newInstance();
    }

    /**
     * 通过clazz 执行config配置中方法获取要实例化的对象
     *
     * @author zyt
     * @param: clazz
     * @date 2024/5/13 16:31
     */
    public Object getServiceInstanceByClazz(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {
        if (serviceMap.containsKey(clazz)){
            return serviceMap.get(clazz);
        }

        if (methodMap.containsKey(clazz)){
            Method method = methodMap.get(clazz);
            Object obj = method.invoke(config);
            serviceMap.put(clazz, obj);
            return obj;
        }
        return null;
    }

    /**
     * 创建普通类实例化方法
     *
     * @author zyt
     * @date 2024/5/13 16:32
     */
    public Object createInstance(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getAnnotation(Autowired.class) != null){
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] objects = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    objects[i] = getServiceInstanceByClazz(parameterTypes[i]);
                }
                // 这里相当于构造器注入了
                return constructor.newInstance(objects);
            }
        }
        // 默认构造器
        return clazz.getConstructor().newInstance();
    }
}
