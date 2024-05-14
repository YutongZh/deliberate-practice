package org.edg.lambda.function;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class Email implements Message{
    public String send(String name, String title) {
        System.out.println("send email to " + title +"."+ name);
        return "email!";
    }
}
