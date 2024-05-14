package org.edg.lambda;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class Main {

    public static void main(String[] args) {
        //正常情况下，我们都是先创建一个类，然后实例化一个对象进行调用，类似下面
        Message email = new Email();
        send(email);
        Message sms = new Sms();
        send(sms);


        //然后当我们有了函数式编程之后就可以替换为下面来替换上面大的方案，我们都可以不用写Email和SMS类，也不用写具体实例化对象
        //但是函数式接口有个特点，就是是个接口，并且有且仅有一个抽象方法，不然无法使用，这是他的限制，所以我们建议在接口上声明@FunctionalInterface
        //他是个函数式接口，这样别人如果新加方法就会编译报错,当然如果只有一个抽象方法，那么不加这个注解也不会报错。
        send((name, title)-> {
            System.out.println("lambda send email to"  +  title +"." +  name);
            return "success";
        });
    }


    static String send(Message message){
        message.send("zyt", "Mr");
        return "success";
    }
}
