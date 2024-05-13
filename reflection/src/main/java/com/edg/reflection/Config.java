package com.edg.reflection;

/**
 * Bean 定义配置类
 *
 * @auther zyt
 * @date 2024/5/13
 */
public class Config {

    public Config() {
    }
    @Bean
    public Address createAddress(){
        return new Address("beijing", "Alibaba");
    }

    @Bean
    public Consumer createConsumer(){
        return new Consumer("zyt", 18, "男");
    }

    public Message createMessage(){
        return new Message();
    }
}
