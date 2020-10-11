package com.sriyoukan.touristmanagment.controller;


import com.sriyoukan.touristmanagment.Repository.*;
import com.sriyoukan.touristmanagment.model.*;
import com.sriyoukan.touristmanagment.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RegisteredPackageRepository registeredPackageRepository;
    @Autowired
    public PackageRepository packageRepository;
    @Autowired
    public NotificationRepository notificationRepository;
    @Autowired
    public RoleRepository roleRepository;
    @Autowired
    public ReviewRepository reviewRepository;





    @PostMapping(value = "/registerPackage")
    public Boolean registerPackage(@RequestBody RegisterPackBody registerPackBody){

        Package pack = packageRepository.findPackageById(registerPackBody.getPackId());
        RegisteredPackage registeredPackage = new RegisteredPackage();
        registeredPackage.setName(pack.getName());
        registeredPackage.setPlacesToVisit(pack.getPlacesToVisit());
        registeredPackage.setDistrict(pack.getDistrict());
        registeredPackage.setProviderEmail(pack.getProviderEmail());
        registeredPackage.setHotelsAvailable(pack.getHotelsAvailable());
        registeredPackage.setTransportationMethod(pack.getTransportationMethod());
        registeredPackage.setUser(userRepository.findUserById(registerPackBody.getUserId()));
        registeredPackage.setTravelAgent(userRepository.findByEmail(pack.getProviderEmail()));
        registeredPackageRepository.insert(registeredPackage);
        Notification notification1 = new Notification();
        notification1.setDescription(String.format("user %s registered the tour %s",registeredPackage.getUser().getName(),registeredPackage.getName()));
        notification1.setToWhom(registeredPackage.getTravelAgent());
        notification1.setSenderEmail(userRepository.findUserById(registerPackBody.getUserId()).getEmail());
        notification1.setRelatedPackId(registeredPackage.getId());
        LocalDateTime ldt = LocalDateTime.now();
        notification1.setTime(ldt);
        notification1.setRole("TRAVELAGENT");
        notificationRepository.save(notification1);
        return true;

    }
    @PostMapping(value="/getAllRegisteredPackage")
    public List<RegisteredPackage> getAllRegisteredPackage(@RequestBody EmailBody emailBody){
       return registeredPackageRepository.findAllByUser(userRepository.findByEmail(emailBody.getEmail()));
    }
    @PostMapping(value = "/cancelPackage")
    public String cancelPackage(@RequestBody  RegisterPackBody registerPackBody){
        RegisteredPackage registeredPackage = registeredPackageRepository.findRegisteredPackageById(registerPackBody.getPackId());
        registeredPackage.setCanceled(true);
        registeredPackageRepository.save(registeredPackage);
        Notification notification1 = new Notification();
        notification1.setDescription(String.format("user %s cancelled the tour %s",registeredPackage.getUser().getName(),registeredPackage.getName()));
        notification1.setToWhom(registeredPackage.getTravelAgent());
        notificationRepository.save(notification1);
        Notification notification2 = new Notification();
        notification2.setDescription(String.format("user %s cancelled the tour %s",registeredPackage.getUser().getName(),registeredPackage.getName()));
        notification2.setToWhom(userRepository.findUserByRoles(roleRepository.findByRole("ADMIN")));
        notificationRepository.save(notification2);
        return "Canceled";
    }
    @PostMapping(value="/getPackages")
    public  List<RegisteredPackage> getUserPackages(@RequestBody RegisterPackBody registerPackBody){
        return registeredPackageRepository.findAllByUser(userRepository.findByEmail(registerPackBody.getUserId()));
    }
    @PostMapping(value="/getUser")
    public User getUser(@RequestBody EmailBody emailBody){
      return  userRepository.findByEmail(emailBody.getEmail());
    }


    @GetMapping(value="/getAllReviews")
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @PostMapping(value="/sendReview")
    public Boolean sendReview(@RequestBody Review review){
        LocalDateTime ldt = LocalDateTime.now();
        review.setTime(ldt);
        reviewRepository.save(review);
        return true;
    }

    @PostMapping(value ="/updateReview")
    public Boolean updateReview(@RequestBody Review review) {
        Review review1 = reviewRepository.findReviewById(review.getId());
        review1.setDescription(review.getDescription());
        LocalDateTime ldt = LocalDateTime.now();

        review1.setTime(ldt);
        reviewRepository.save(review1);


        return true;
    }

    @PostMapping(value = "/deleteReview")
    public Boolean deleteReview(@RequestBody IdBody idBody){
        reviewRepository.deleteById(idBody.getId());

        return true;
    }
}
