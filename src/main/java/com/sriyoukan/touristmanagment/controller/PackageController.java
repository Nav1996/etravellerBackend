package com.sriyoukan.touristmanagment.controller;


import com.sriyoukan.touristmanagment.Repository.NotificationRepository;
import com.sriyoukan.touristmanagment.Repository.PackageRepository;
import com.sriyoukan.touristmanagment.Repository.UserRepository;
import com.sriyoukan.touristmanagment.model.Notification;
import com.sriyoukan.touristmanagment.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PackageController {

    @Autowired

    public PackageRepository packageRepository;

    @Autowired
    public NotificationRepository notificationRepository;

    @Autowired
    public UserRepository userRepository;



    @PostMapping(value="/package")
    public Boolean createPackage(@RequestBody Package pack){
        Notification notification = new Notification();
        notification.setDescription(String.format("You offered a tour plan %s",pack.getName()));
        LocalDateTime ldt = LocalDateTime.now();
        notification.setTime(ldt);
        notification.setToWhom(userRepository.findByEmail(pack.getProviderEmail()));
        notificationRepository.save(notification);

        Package createdPackage = packageRepository.insert(pack);

        return true;
    }

    @GetMapping(value="/getAllPackage")
    public List<Package> getAllPackage(){

        return packageRepository.findAll();

    }

    @PostMapping(value="/packageUpdate")
    public Boolean updatePackage(@RequestBody Package pack){
        Package oldPack = packageRepository.findPackageById(pack.getId());
        oldPack.setName(pack.getName());
        oldPack.setPlacesToVisit(pack.getPlacesToVisit());
        oldPack.setDistrict(pack.getDistrict());
        oldPack.setProviderEmail(pack.getProviderEmail());
        oldPack.setHotelsAvailable(pack.getHotelsAvailable());
        oldPack.setTransportationMethod(pack.getTransportationMethod());
        packageRepository.save(oldPack);

        return true;

    }





}
