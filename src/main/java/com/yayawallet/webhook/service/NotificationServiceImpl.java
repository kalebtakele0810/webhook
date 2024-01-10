package com.yayawallet.webhook.service;

import com.yayawallet.webhook.dto.ApiResponse;
import com.yayawallet.webhook.dto.WebHookRequest;
import com.yayawallet.webhook.entity.TransactionNotifications;
import com.yayawallet.webhook.repository.TransactionNotificationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@RequiredArgsConstructor
@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final TransactionNotificationsRepository transactionNotificationsRepository;

    @Override
    public ApiResponse processNotification(WebHookRequest request) {

        /*
        Add logic with transaction notification
        */

        ApiResponse apiResponse;
        try {
            transactionNotificationsRepository.save(TransactionNotifications.builder()
                    .id(request.getId())
                    .amount(request.getAmount())
                    .currency(request.getCurrency())
                    .created_at_time(new Date(TimeUnit.SECONDS.toMillis(request.getCreated_at_time())))
                    .timestamp(new Date(TimeUnit.SECONDS.toMillis(request.getTimestamp())))
                    .cause(request.getCause())
                    .full_name(request.getFull_name())
                    .account_name(request.getAccount_name())
                    .invoice_url(request.getInvoice_url())
                    .build());
        } catch (Exception e) {

            apiResponse = ApiResponse.builder()
                    .id(request.getId())
                    .responseDesc("Error processing the request: " + e.getMessage())
                    .responseCode("1")
                    .build();

            log.info("Transaction notification response {} | response code {} | {}", request.getId(), apiResponse.getResponseCode(), apiResponse.getResponseDesc());

            return apiResponse;
        }

        apiResponse = ApiResponse.builder()
                .id(request.getId())
                .responseDesc("Successfully processed!")
                .responseCode("0")
                .build();

        log.info("Transaction notification response {} | response code {} | {}", request.getId(), apiResponse.getResponseCode(), apiResponse.getResponseDesc());

        return apiResponse;
    }
}



