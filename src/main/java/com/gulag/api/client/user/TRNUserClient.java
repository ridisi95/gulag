package com.gulag.api.client.user;

import com.gulag.api.client.WebClientFilter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TRNUserClient {

    static String USER_PROFILE_URL = "https://api.tracker.gg/api/v2/warzone/standard/matches/atvi/%s?type=wz";

    public Object verifyUser(String unoTag) {

        String formattedUnoTag = String.format(USER_PROFILE_URL, unoTag.replace("#", "%23"));

        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(formattedUnoTag);
        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient.ResponseSpec responseSpec = WebClient
                .builder()
                .uriBuilderFactory(uriBuilderFactory)
                .baseUrl(formattedUnoTag)
                .filter(WebClientFilter.logResponse())
                .build()
                .get()
                .retrieve();

        return responseSpec.toEntity(String.class).block();
    }
}
