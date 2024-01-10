package com.yayawallet.webhook.controller;

import com.yayawallet.webhook.dto.ApiResponse;
import com.yayawallet.webhook.dto.WebHookRequest;
import com.yayawallet.webhook.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("notify/")
@Slf4j
public class MainController {
    private final NotificationService notificationService;


    @PostMapping("/process")
    ApiResponse processNotification(@RequestBody WebHookRequest notifyRequest) {

        log.info("Transaction notification {} | for customer {}", notifyRequest.getId(), notifyRequest.getAccount_name());

        return notificationService.processNotification(notifyRequest);

    }


}
