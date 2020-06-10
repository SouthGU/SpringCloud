package com.xgl.repository;

import com.xgl.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/2/17:10
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,String> {
}
