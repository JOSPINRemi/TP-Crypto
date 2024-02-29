package com.example.user_api.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field("last_name")
    private String lastName;

    @Field("first_name")
    private String firstName;

    private String email;

    private String password;
}
