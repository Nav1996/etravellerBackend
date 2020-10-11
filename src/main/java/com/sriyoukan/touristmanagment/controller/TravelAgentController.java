package com.sriyoukan.touristmanagment.controller;

import com.sriyoukan.touristmanagment.Repository.NotificationRepository;
import com.sriyoukan.touristmanagment.Repository.RoleRepository;
import com.sriyoukan.touristmanagment.Repository.UserRepository;
import com.sriyoukan.touristmanagment.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TravelAgentController {
    @Autowired
    public UserRepository travelAgentRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping(value = "/getNotification")
    public List<Notification> getNotification(@RequestBody EmailBody email){
        return notificationRepository.findAllByToWhom(userRepository.findByEmail(email.getEmail()));
    }

    @PostMapping(value="sendNotification")
    public Boolean sendNotification(Notification notification){
        notificationRepository.insert(notification);

        return true;
    }







}
