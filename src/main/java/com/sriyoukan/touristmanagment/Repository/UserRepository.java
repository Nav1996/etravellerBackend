package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.Role;
import com.sriyoukan.touristmanagment.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    List<User> findByRoles(Role role);
    User findUserByRoles(Role role);
    User findByEmail(String email);
    User findUserById(String id);

    @DeleteQuery
    User deleteUserByEmail(String email);



}
