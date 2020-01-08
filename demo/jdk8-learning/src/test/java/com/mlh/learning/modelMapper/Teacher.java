package com.mlh.learning.modelMapper;

import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.modelMapper
 * @Description:
 * @date Date : 2019年04月25日 10:53 AM
 **/
public class Teacher {
    private String name;
    private List<User> userList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
