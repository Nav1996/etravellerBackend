package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.Notification;
import com.sriyoukan.touristmanagment.model.Role;
import com.sriyoukan.touristmanagment.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification,String> {

    List<Notification> findAllByToWhom(User user);
    Notification findNotificationById(String id);
    List<Notification> findNotificationsByRole(String role);

}
