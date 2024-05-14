package org.edg.lambda.optional;

import java.util.Optional;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class OptionalMain {
    public static void main(String[] args) {

        //正常逻辑判断是下面的写法
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findUserByName("zyt1");
        if (user != null){
            System.out.println(user.getName());
        } else {
            System.out.println("用户不存在");
        }

        //Optional 相当于一个容器，我们可以装任何对象，包括空值null,下面是两个包装方法，创建一个Optional对象
        Optional<Object> empty = Optional.empty();
        //Optional<User> user1 = Optional.of(user); // of方法创建一个Optional对象，如果传入的参数为null，会抛出空指针异常，当明确知道不为空可以使用
        Optional<User> user2 = Optional.ofNullable(user); // ofNullable方法创建一个Optional对象，如果传入的参数为null，不会抛出空指针异常
        System.out.println(user2.isPresent()); // isPresent方法判断Optional对象是否为空，如果为空返回false，不为空返回true
        //System.out.println(user2.get());// get方法获取Optional对象中的值，如果为空会抛出空指针异常, 这里不推荐使用
        System.out.println(user2.orElse(new User("zyt", 15)).getAge());  // orElse方法获取Optional对象中的值，如果为空返回默认值
        System.out.println(user2.orElseGet(()->new User("zyt", 15)).getAge());// orElseGet方法获取Optional对象中的值，如果为空返回默认值
        //orElse和orElseGet方法的区别是orElse不管是否为空都会执行，orElseGet如果为空才会执行后面的。
        //System.out.println(user2.orElseThrow(()->new RuntimeException("抛出异常，用户不存在"))); // orElseThrow方法获取Optional对象中的值，如果为空抛出异常
        user2.ifPresent(user1-> System.out.println(user1.getName()));// ifPresent方法判断Optional对象是否为空，如果为空不执行，不为空执行
        // java 9 还有个ifPresentOrElse，包含两种结果处理 user2.ifPresentOrElse(str -> System.out.println(str.length()), () -> System.out.println("为空"));
        //还可以过滤filter
        System.out.println(user2.filter(n -> n.getAge() > 20).orElseGet(()->new User("bob", 15)).getName());
        //转换为map
        System.out.println(user2.map(User::getAge).orElse(30));
        user2.map(User::getAge).ifPresent(System.out::println);
        //多层嵌套Optional可以使用flatmap将两个嵌套的optional压扁成一个optional
        Optional<Optional<User>> user21 = Optional.of(user2);
        System.out.println(user21.flatMap(user1 -> user1.map(User::getAge)).orElse(0));

    }
}
