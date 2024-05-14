package org.edg.lambda.optional;

/**
 * @auther zyt
 * @date 2024/5/14
 */
public class UserRepository {


    public User findUserByName(String name) {
        if ("zyt".equals(name)){
            return new User(name, 18);
        } else {
            return null;
        }
    }
}
