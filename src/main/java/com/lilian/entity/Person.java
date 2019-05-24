package com.lilian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jpa-demo
 * @author muyuer 182443947@qq.com
 * @date 2018-12-03 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phone;

}
