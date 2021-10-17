package com.gulag.api.client.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/**
 * Fetches XSRF-TOKEN which is required to sign in Call of Duty api
 */

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CODInizialize {

    static String INIZIALIZE_LOGIN = "https://profile.callofduty.com/cod/login";
    public static String XSRF_TOKEN = "XSRF-TOKEN";

    public String doRequest() {

        WebClient.ResponseSpec responseSpec = WebClient
                .builder()
                .baseUrl(INIZIALIZE_LOGIN)
                .exchangeStrategies(ExchangeStrategies.withDefaults())
                .build()
                .get()
                .retrieve();

        log.info(responseSpec.toString());

        List<String> responseHeaders = responseSpec.toBodilessEntity().block().getHeaders().get(HttpHeaders.SET_COOKIE);

//      #TODO add specified exception for this part, add log
        String rawXSRF = responseHeaders.stream().filter(header -> StringUtils.startsWith(header, XSRF_TOKEN)).findFirst().orElseThrow();

        String xsrfHeader = StringUtils.substringBetween(rawXSRF, "=", ";");

        log.info(xsrfHeader);

        return xsrfHeader;
    }
}
