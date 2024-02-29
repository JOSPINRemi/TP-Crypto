package com.example.wallet_api.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document(collection = "wallet")
public class Wallet {

    @Id
    private String id;

    @Field("user_id")
    private String userId;
    @DocumentReference
    private List<Transaction> transactions = new ArrayList<>();


}
