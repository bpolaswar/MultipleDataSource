package com.example.multidb.mongo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "user")
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    @Id
    private String id;

    @Column
    private String name;
}
