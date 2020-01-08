package com.mlh.learning.modelmapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.mlh.learning.json.JsonUtil;
import org.modelmapper.Converter;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.context.properties.PropertyMapper;

import javax.print.attribute.standard.Destination;
import java.util.List;

public class PostVO {
    private Long id;
    private boolean like;
    private int likeNum;
    private List<String> attachments;

    public PostVO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }



    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostDO postDO = new PostDO();
        postDO.setId(3L);
        postDO.setLikeNum(2);
        postDO.setAttachment("[\"w22qw\",\"wqw\"]");
        System.out.println(JsonUtil.fromJson(postDO.getAttachment(), new TypeReference<List<String>>() {
        }));
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }


    @Override
    public String toString() {
        return "PostVO{" +
                "id=" + id +
                ", like=" + like +
                ", likeNum=" + likeNum +
                ", attachments=" + attachments +
                '}';
    }
}
