package com.example.timeline_two;

public class Timeline {
    private String contentId;
    private String userName;
    private String content;
    private String date;

    public Timeline( String userName, String content, String date) {
        this.userName = userName;
        this.content = content;
        this.date = date;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
