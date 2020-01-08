package com.mlh.learning.modelMapper;

import com.google.common.base.Objects;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.modelMapper
 * @Description:
 * @date Date : 2019年04月25日 10:58 AM
 **/
public class SimpleTeacher {
    private String name;
    private List<SimpleUser> simpleUserList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SimpleUser> getSimpleUserList() {
        return simpleUserList;
    }

    public void setSimpleUserList(List<SimpleUser> simpleUserList) {
        this.simpleUserList = simpleUserList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("simpleUserList", simpleUserList)
                .toString();
    }
}
