package com.yayawallet.webhook.repository;


import com.yayawallet.webhook.entity.TransactionNotifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionNotificationsRepository extends JpaRepository<TransactionNotifications, String> {

}
