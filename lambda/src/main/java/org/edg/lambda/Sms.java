package org.edg.lambda;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class Sms implements Message{
    public String send(String name, String title) {
        System.out.println("send sms to " + title + title);
        return "sms!";
    }
}
