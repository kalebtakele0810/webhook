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
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RestController
@RequestMapping("notify/")
@Slf4j
public class MainController {
    private final NotificationService notificationService;

    @PostMapping("/process")
    Mono<ApiResponse> processNotification(@RequestBody WebHookRequest notifyRequest) {

        log.info("Transaction notification {} | for customer {}", notifyRequest.getId(), notifyRequest.getAccount_name());

        Mono<ApiResponse> immediateResponse = Mono.just(ApiResponse.builder()
                .id(notifyRequest.getId())
                .responseDesc("Successfully processed!")
                .responseCode("0")
                .build());
        return immediateResponse.flatMap(ir ->
                Mono.fromFuture(() -> notificationProcessing(notifyRequest))
                        .map(rsp -> rsp)
        );

    }

    private CompletableFuture<ApiResponse> notificationProcessing(WebHookRequest rqst) {
        return CompletableFuture.completedFuture(notificationService.processNotification(rqst));
    }


}
