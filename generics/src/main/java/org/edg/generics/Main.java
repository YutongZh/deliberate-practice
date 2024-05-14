package org.edg.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class Main {

    public static void main(String[] args) {
        whyUseGenerics();
        System.out.println("=============");
        genericClass();
        System.out.println("=============");
        genericMethod();
    }
    


    
    public static void whyUseGenerics() {
        //为什么要使用泛型，下面两个列子可以看出，每次都要创建相同的类，才能实现打印的功能。
        IntegerPrinter integerPrinter = new IntegerPrinter(10);
        integerPrinter.print();
        StringPrinter stringPrinter = new StringPrinter("Hello World");
        stringPrinter.print();
        //那么我们可以优化为泛型,只要我们修改对应的类型就可以实现多种类型的打印功能,很大程度减少重复工作
        GenericPrinter<Integer> genericIntegerPrinter = new GenericPrinter<Integer>(10);
        genericIntegerPrinter.print();
        // 也可以传入多个泛型类型  KTV
        GenericPrinter2<String, Integer> genericPrinter2 = new GenericPrinter2<String, Integer>("Hello World", 10);
        genericPrinter2.print();
        // 经常使用的泛型类型 比如List  Set
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("456");
        System.out.println(list.get(0));
        //但是不建议使用List<Object>, 因为泛型只是在编译的时候校验，运行时候不校验，比如下面e2运行就会报错
        List<Object>  objects = new ArrayList<Object>();
        objects.add("123");
        objects.add(123);
        String e1 = (String) objects.get(0);
        //String e2 = (String) objects.get(1); //此处编译时候不报错，运行时候就会报错
        System.out.println(e1);
    }

    public static void genericClass() {
        //当泛型定义为<T extends Vehicle & Thing>  表示泛型的类型必须继承Vehicle和Thing接口，否则会报错
        GenericPrinter3<Car> genericPrinter3 = new GenericPrinter3<Car>(new Car("red"));
        genericPrinter3.print();
        //GenericPrinter3<Bus> genericPrinter4 = new GenericPrinter3<Bus>(new Bus()); //这里传入Bus类型，会报错，因为他没有继承Thing接口
        //还有一点 <T extends Vehicle & Thing>，泛型类中定义泛型必须是类在前，接口在后，类似<T extends Thing & Vehicle> 会报错
    }

    public static void genericMethod() {
        // 泛型方法中，参数的泛型仅仅只代表一个占位符，需要在返回值前用<T>来声明他是什么类型
        GenericPrinter4 genericPrinter4 = new GenericPrinter4();
        genericPrinter4.print(new Car("red"));
        genericPrinter4.print(122222);

        //这里泛型定义的时候<T extends Vehicle & Thing>，并不是Vehicle和Ting的子类，所以这里其他类型就会报错
        //genericPrinter4.print2(1222);  String 类型就会报错
        genericPrinter4.print(new Car("blue"));
        //还有就是我们定义泛型方法返回值的时候不能够定义为super这种下限，因为泛型方法返回值必须是明确的


        //通配符 当我们调用print方法参数为List<Object>的时候，他执行后会导致编译器报错，因为List<String> 并不是List<Object>的子类
        //所以我们就可以通过？通配符来代替。
        // <? extends Vehicle>  表示泛型方法参数上限是Vehicle，必须接受一个Vehicle或者Vehicle的子类
        // <? super Car> 表示泛型方法参数下限时候Car，必须接受一个Car或者Car的父类
        // 通常来说因为我们做的尽可能通用情况，方法参数是尽量使用接受一个下限（super），返回值用上限（extends）。即生产用extends 消费用super
        List<Vehicle> list = new ArrayList<Vehicle>();
        list.add(new Vehicle("red"));
        printExtends(list);

        printSuper(list);
    }

    public static void printExtends(List<? extends Vehicle> item){
        System.out.println(item);
    }

    public static void printSuper(List<? super Car> item){
        System.out.println(item);
    }

}





