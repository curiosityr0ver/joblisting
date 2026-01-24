package com.telusco.joblisting.repository;

import com.telusco.joblisting.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ tech: { $regex: ?0, $options: 'i' } }")
    List<Post> findByTechIgnoreCase(String tech);
}
