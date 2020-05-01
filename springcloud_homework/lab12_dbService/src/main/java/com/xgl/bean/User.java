package com.xgl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Auther: sise.xgl
 * @Date: 2020/6/2/17:08
 * @Description:
 */
@Entity
@Table(name = "stu")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    String uid;
    String username;
    String password;
}
