package com.sriyoukan.touristmanagment.Repository;

import com.sriyoukan.touristmanagment.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review,String> {
   Review findReviewById(String id);
}
