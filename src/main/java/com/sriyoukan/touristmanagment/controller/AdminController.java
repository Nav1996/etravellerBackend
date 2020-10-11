package com.sriyoukan.touristmanagment.controller;


import com.sriyoukan.touristmanagment.Repository.*;
import com.sriyoukan.touristmanagment.model.*;
import com.sriyoukan.touristmanagment.model.Package;
import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    public UserRepository adminRepository;

    @Autowired

    public  PackageRepository packageRepository;

    @Autowired
    public AuthController authController;

    @Autowired
    public NotificationRepository notificationRepository;

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public RegisteredPackageRepository registeredPackageRepository;

    @GetMapping(value="/getTravelAgent")
    public List<User> getAllUser(){
        Role role = roleRepository.findByRole("TRAVELAGENT");
        List<User> newList = adminRepository.findByRoles(role);
        return newList;
    }
    @GetMapping(value="/getQuide")
    public List<User> getAllUserQuide(){
        Role role = roleRepository.findByRole("QUIDE");
        List<User> newList = adminRepository.findByRoles(role);
        return newList;
    }


    @PostMapping(value="/updateTravelAgent")
    public String updateTravelAgent(@RequestBody User user){
        User userOld = adminRepository.findUserById(user.getId());
        userOld.setEmail(user.getEmail());
        userOld.setPassword(user.getPassword());
        userOld.setName(user.getName());
        userOld.setMobileNo(user.getMobileNo());
        adminRepository.save(userOld);

        return "Updated";
    }


    @PostMapping(value="/addPackage")
    public Boolean addPackage(@RequestBody  RegisterPackBody registerPackBody){
        RegisteredPackage registeredPackage = registeredPackageRepository.findRegisteredPackageById(registerPackBody.getPackId());
        registeredPackage.setAccepted(true);
        registeredPackageRepository.save(registeredPackage);
        return true;
    }
    @PostMapping(value="/addTravelAgent")
    public String addTravelAgent(@RequestBody User user){
        authController.registerTravelAgent(user);
        return "created Successfully";
    }
    @PostMapping(value="/deletePackage")
    public Boolean deletePackage(@RequestBody RegisterPackBody registerPackBody){
        packageRepository.deleteById(registerPackBody.getPackId());
        return true;
    }
    @PostMapping(value="/deleteTravelAgent")
    public String deleteTravelAgent(@RequestBody  TravelAgentEmailBody travelAgentEmailBody){
        //Package pack = packageRepository.findPackageByProviderEmail(travelAgentEmailBody.getEmail());
        //packageRepository.delete(pack);
        adminRepository.delete(adminRepository.findByEmail(travelAgentEmailBody.getEmail()));
        return "Agent and the package they offered are deleted";
    }
   

    @GetMapping(value = "/getNewRequestsForPackages")
    public List<RegisteredPackage> getAllNewRequestsForPackages(){
        return registeredPackageRepository.findAllByIsAcceptedAndIsCanceled(false,false);
    }
    @GetMapping(value="/acceptedPackage")
    public List<RegisteredPackage> getAllAcceptedPackages(){
        return registeredPackageRepository.findAllByIsAccepted(true);
    }

}
