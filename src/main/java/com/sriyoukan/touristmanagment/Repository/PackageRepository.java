package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.Package;
import com.sriyoukan.touristmanagment.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PackageRepository extends MongoRepository<Package,String> {
    void deleteAllBy(User user);
    Package findPackageById(String id);
    Package findPackageByProviderEmail(String email);
}
