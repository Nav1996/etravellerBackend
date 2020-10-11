package com.sriyoukan.touristmanagment.controller;

public class NotificationEmailBody {
  private   String senderEmail;
  private  String receiverEmail;
  private String relatedPackId;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getRelatedPackId() {
        return relatedPackId;
    }

    public void setRelatedPackId(String relatedPackId) {
        this.relatedPackId = relatedPackId;
    }
}
