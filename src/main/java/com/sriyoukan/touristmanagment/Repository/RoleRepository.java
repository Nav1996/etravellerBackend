package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);

}
