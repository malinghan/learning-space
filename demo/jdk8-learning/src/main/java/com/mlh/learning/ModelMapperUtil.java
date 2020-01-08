package com.mlh.learning;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : linghan.ma
 * @Package com.xrxs.helper
 * @Description:
 * @date Date : 2019年04月18日 2:44 AM
 **/
public class ModelMapperUtil {

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFullTypeMatchingRequired(true);
    }


    /**
     * 将一个对象转换成另外一个对象:前提是属性名称和类型都一样,缺省的字段会为null
     *
     * @param source
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convert(Object source, Class<T> clazz) {
        T t;
        try {
            t = mapper.map(source, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    /**
     * 将一个list转换成另一个list:前提是属性名称和类型都一样,缺省的字段会为null
     * @param objectList
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> convetList(List<?> objectList, Class<T> clazz) {
        if (objectList == null) {
            return null;
        }
        if (objectList.size() == 0) {
            return new ArrayList<>();
        }
        List<T> list;
        try {
            list = objectList.stream().map(o -> convert(o, clazz)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
