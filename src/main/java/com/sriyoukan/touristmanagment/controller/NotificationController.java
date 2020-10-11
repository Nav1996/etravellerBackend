package com.sriyoukan.touristmanagment.controller;
import java.time.LocalDateTime;


import com.sriyoukan.touristmanagment.Repository.NotificationRepository;
import com.sriyoukan.touristmanagment.Repository.UserRepository;
import com.sriyoukan.touristmanagment.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotificationController {

    @Autowired
    public NotificationRepository notificationRepository;

    @Autowired
    public UserRepository userRepository;



    @PostMapping(value="/notification")
    public Boolean createNotification(@RequestBody Notification notification){
        LocalDateTime ldt = LocalDateTime.now();
        notification.setTime(ldt);
        notificationRepository.save(notification);

        return true;
    }
    @PostMapping(value = "/updateNotification")
    public Boolean updateNotification(@RequestBody IdBody id){
        Notification notification = notificationRepository.findNotificationById(id.getId());
        notification.setRead(true);
        LocalDateTime ldt = LocalDateTime.now();
        notification.setTime(ldt);
        notificationRepository.save(notification);

        return true;
    }
    @PostMapping(value = "/acceptTour")
    public Boolean acceptTour(@RequestBody NotificationEmailBody notificationEmailBody){
        Notification notification = new Notification();
        notification.setRole("TRAVELAGENT");
        notification.setDescription("wishes to work");
        notification.setSenderEmail(notificationEmailBody.getSenderEmail());
        notification.setToWhom(userRepository.findByEmail(notificationEmailBody.getReceiverEmail()));
        notification.setRelatedPackId(notificationEmailBody.getRelatedPackId());
        notification.setRead(true);
        LocalDateTime ldt = LocalDateTime.now();
        notification.setTime(ldt);
        notificationRepository.save(notification);
        return true;

    }

}
