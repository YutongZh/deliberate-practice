package org.edg.lambda;

/**
 * @auther zyt
 * @date 2024/5/14
 */
@FunctionalInterface
public interface Message {

    String send(String name, String title);
}
