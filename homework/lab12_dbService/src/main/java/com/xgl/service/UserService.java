package com.xgl.service;

import com.xgl.bean.User;
import com.xgl.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/2/17:10
 * @Description:
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }
    public User selectByKey(String uid){
        return userRepository.findById(uid).get();
    }
}
