package com.hebut.ctalk.dto;

public class MessageDTO {
    private String mid;
    private String title;   //消息主题
    private UserDTO author; //消息作者,这里应该是作者实体{id, name, level, profilePicture(头像)}
    private String date;    //消息日期
    private String content; // 内容
    private String type;    //消息类型{消息,通知} message  inform

    public MessageDTO() {

    }

    public MessageDTO(String id, String title, UserDTO author, String date, String content, String type) {
        this.mid = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
        this.type = type;
    }

    public String getMid() { return mid; }

    public void setMid(String mid) { this.mid = mid; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public UserDTO getAuthor() { return author; }

    public void setAuthor(UserDTO author) { this.author = author; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}

