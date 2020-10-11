package com.sriyoukan.touristmanagment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "notification")
public class Notification {

    @Id
    String id;
    LocalDateTime time;
    String description;
    Boolean isRead = false;
    User toWhom;
    String senderEmail;
    String role;
    String relatedPackId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getToWhom() {
        return toWhom;
    }

    public void setToWhom(User toWhom) {
        this.toWhom = toWhom;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        this.isRead = read;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRelatedPackId() {
        return relatedPackId;
    }

    public void setRelatedPackId(String relatedPackId) {
        this.relatedPackId = relatedPackId;
    }
}
