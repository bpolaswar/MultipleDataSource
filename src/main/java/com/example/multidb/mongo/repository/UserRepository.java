package com.example.multidb.mongo.repository;

import com.example.multidb.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mongoUserRepository")
public interface UserRepository extends MongoRepository<User, UUID> {
}
