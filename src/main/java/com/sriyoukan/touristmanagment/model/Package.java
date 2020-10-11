package com.sriyoukan.touristmanagment.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "package")
public class Package {

    @Id
    String id;
    String name;
    List<String> placesToVisit;
    String district;
    String providerEmail;
    List<String> hotelsAvailable;
    String transportationMethod;
    Boolean isAccepted = false;
    String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlacesToVisit() {
        return placesToVisit;
    }

    public void setPlacesToVisit(List<String> placesToVisit) {
        this.placesToVisit = placesToVisit;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String email) {
        this.providerEmail = email;
    }

    public List<String> getHotelsAvailable() {
        return hotelsAvailable;
    }

    public void setHotelsAvailable(List<String> hotelsAvailable) {
        this.hotelsAvailable = hotelsAvailable;
    }

    public String getTransportationMethod() {
        return transportationMethod;
    }

    public void setTransportationMethod(String transportationMethod) {
        this.transportationMethod = transportationMethod;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
