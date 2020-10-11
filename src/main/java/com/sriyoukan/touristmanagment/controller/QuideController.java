package com.sriyoukan.touristmanagment.controller;


import com.sriyoukan.touristmanagment.Repository.NotificationRepository;
import com.sriyoukan.touristmanagment.Repository.RegisteredPackageRepository;
import com.sriyoukan.touristmanagment.Repository.UserRepository;
import com.sriyoukan.touristmanagment.model.Notification;
import com.sriyoukan.touristmanagment.model.RegisteredPackage;
import com.sriyoukan.touristmanagment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuideController {

    @Autowired
    public UserRepository quideRepository;
    @Autowired
    public RegisteredPackageRepository registeredPackageRepository;
    @Autowired
    public NotificationRepository notificationRepository;

    @PostMapping(value="/leavefrompackage")
    public  String leaveFromPackage(User user){
        RegisteredPackage registeredPackage=registeredPackageRepository.findByUser(user);
        registeredPackage.setQuide(null);
        registeredPackageRepository.save(registeredPackage);
        Notification notification = new Notification();
        notification.setTime(LocalDateTime.now());
        notification.setDescription("Quide left  the package");
        return "notification added";

    }

    @GetMapping(value="getQuideNotification")
    public  List<Notification> getAllNotification(){
        return notificationRepository.findNotificationsByRole("QUIDE");
    }



}
