package org.edg.lambda.function;

/**
 * @auther zyt
 * @date 2024/5/14
 */
@FunctionalInterface
public interface Message {

    String send(String name, String title);
}
