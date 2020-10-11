package com.sriyoukan.touristmanagment.model;

import com.sriyoukan.touristmanagment.controller.TravelAgentController;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "registeredpackage")
public class RegisteredPackage  {
    @Id
    String id;
    String name;
    List<String> placesToVisit;
    String district;
    String providerEmail;
    List<String> hotelsAvailable;
    String transportationMethod;
    Boolean isAccepted = false;
    Boolean isCanceled = false;
    Boolean isFinished = false;
    private User travelAgent;
    private User quide;
    private User user;

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

    public void setProviderEmail(String userEmail) {
        this.providerEmail = userEmail;
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

    public User getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(User travelAgent) {
        this.travelAgent = travelAgent;
    }

    public User getQuide() {
        return quide;
    }

    public void setQuide(User quide) {
        this.quide = quide;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
