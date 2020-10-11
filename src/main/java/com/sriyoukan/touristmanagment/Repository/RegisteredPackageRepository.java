package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.RegisteredPackage;
import com.sriyoukan.touristmanagment.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RegisteredPackageRepository extends   MongoRepository<RegisteredPackage,String>{
    RegisteredPackage findByUser(User user);
    RegisteredPackage findRegisteredPackageById(String id);
    List<RegisteredPackage> findAllByIsAcceptedAndIsCanceled(Boolean b1, Boolean b2);
    List<RegisteredPackage> findAllByIsAccepted(Boolean b1);
    List<RegisteredPackage> findAllByUser(User user);
}



