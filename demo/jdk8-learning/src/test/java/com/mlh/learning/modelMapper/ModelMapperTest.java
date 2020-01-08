package com.mlh.learning.modelMapper;

import org.junit.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.modelMapper
 * @Description:
 * @date Date : 2019年04月25日 10:54 AM
 **/

public class ModelMapperTest {

    @Test
    public void testModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        User user1 = new User();
        user1.setName("aaa");
        user1.setLabel("hello");

        User user2 = new User();
        user2.setName("aaa");
        user2.setLabel("hello");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Teacher teacher = new Teacher();
        teacher.setName("t1");
        teacher.setUserList(userList);

        SimpleTeacher simpleTeacher = new SimpleTeacher();
        modelMapper.createTypeMap(User.class,SimpleUser.class);
//        modelMapper.addConverter(new Converter<User, SimpleUser>() {
//            @Override
//            public SimpleUser convert(MappingContext<User, SimpleUser> mappingContext) {
//
//            }
//        });
        modelMapper.map(teacher,simpleTeacher);

        System.out.println(simpleTeacher);

    }
}
