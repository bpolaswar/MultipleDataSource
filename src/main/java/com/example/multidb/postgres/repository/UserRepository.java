package com.example.multidb.postgres.repository;

import com.example.multidb.postgres.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("postgresUserRepository")
public interface UserRepository extends JpaRepository<User, UUID> {
}
