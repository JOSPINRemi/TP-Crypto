package com.example.wallet_api.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "transaction")
public class Transaction {
    @Id
    private String id;

    private String type;
    @Field("crypto_quantity")
    private Double cryptoQuantity;
    @Field("id_crypto")
    private String idCrypto;
    @Field("date_time")
    private LocalDateTime dateTime;
}
