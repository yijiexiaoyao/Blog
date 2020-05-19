package tech.acodesigner.dto;

import java.util.ArrayList;

/**
 *
 */
public class MessageDto {
    private Integer id;
    private Integer type;
    private Integer pid;
    private String content;
    private String pubDate;
    private Integer replyType;
    private UserDto user;
    private ArrayList<MessageReplyDto> chirdren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ArrayList<MessageReplyDto> getChirdren() {
        return chirdren;
    }

    public void setChirdren(ArrayList<MessageReplyDto> chirdren) {
        this.chirdren = chirdren;
    }
}
