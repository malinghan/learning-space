package com.mlh.learning.modelmapper;

public class PostDO {
    private Long id;
    private String commentId;
    private Long postId;
    private int likeNum;
    private String attachment;

    public PostDO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public String toString() {
        return "PostDO{" +
                "id=" + id +
                ", commentId='" + commentId + '\'' +
                ", postId=" + postId +
                ", likeNum=" + likeNum +
                ", attachment='" + attachment + '\'' +
                '}';
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}