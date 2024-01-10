package com.yayawallet.webhook.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Table(name = "transaction_list")
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class TransactionNotifications {

    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String currency;

    @CreationTimestamp
    private Date created_at_time;

    @CreationTimestamp
    private Date timestamp;

    @Column(nullable = false)
    private String cause;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String account_name;

    @Column(nullable = false)
    private String invoice_url;

}
