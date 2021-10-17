package com.gulag.api.client;

import com.gulag.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Slf4j
public class WebClientFilter {

    public static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> logBody(response));
    }

    private static Mono<ClientResponse> logBody(ClientResponse response) {
        if (response.statusCode() != null && (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError())) {
            return response.bodyToMono(String.class)
                           .flatMap(body -> {
                               log.info("response error message: {}", body);
                               return Mono.error(new DataNotFoundException("Object not found"));
                           });
        } else {
            return Mono.just(response);
        }
    }

}
