package com.example.multidb.mysql.repository;

import com.example.multidb.mysql.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mysqlUserRepository")
public interface UserRepository extends JpaRepository<User, UUID> {
}
