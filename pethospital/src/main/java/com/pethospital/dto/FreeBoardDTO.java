package com.pethospital.dto;

import java.util.Date;

public class FreeBoardDTO {
    private int freeBoardId;
    private String userId;
    private String nickname;

    private String title;
    private String content;
    private String imageFile;

    private Date regdate;
    private Date updatedate;
    private Date deletedate;
    private int views; 			// 조회수
    private int likes;			// 좋아요

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public Date getUpdatedate() {
        return updatedate;
    }
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
    public Date getDeletedate() {
        return deletedate;
    }
    public void setDeletedate(Date deletedate) {
        this.deletedate = deletedate;
    }
    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFreeBoardId() {
        return freeBoardId;
    }
    public void setFreeBoardId(int freeBoardId) {
        this.freeBoardId = freeBoardId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImageFile() {
        return imageFile;
    }
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
