package com.yayawallet.webhook.service;

import com.yayawallet.webhook.dto.ApiResponse;
import com.yayawallet.webhook.dto.WebHookRequest;

public interface NotificationService {
    ApiResponse processNotification(WebHookRequest request) ;

}

