package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @auther 李明浩
 * @date 9/21/2018 11:14 AM
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str, String type);
    ServerResponse<String> forgetGetQuestion(String username);
    ServerResponse<String> checkAnswer(String username,String question,String answer);
}
