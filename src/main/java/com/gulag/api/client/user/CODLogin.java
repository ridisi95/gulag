package com.gulag.api.client.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static com.gulag.api.client.user.CODInizialize.XSRF_TOKEN;

@Slf4j
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CODLogin {

    static String LOGIN_URL = "https://profile.callofduty.com/do_login?new_SiteId=cod";

    static String MOCKOON_URL = "http://127.0.0.1:3000/users";


    static String API_CSRF_TOKEN = "API_CSRF_TOKEN";


    public String doRequest(String xsrfHeader){


//        MultiValueMap<String, String> multiValuedMap = new LinkedMultiValueMap();
//        multiValuedMap.put("gtm.custom.bot.flag", List.of("human"));
//        multiValuedMap.put("gpv_pn", List.of("callofduty%3Amycod%3Alogin"));


        WebClient.ResponseSpec responseSpec = WebClient
                .builder()
                .baseUrl(LOGIN_URL)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE, "boundary=--------------------------289178681682133397753352")
                .defaultCookie(XSRF_TOKEN, xsrfHeader)
                .build()
                .post()
                .body(BodyInserters
                        .fromMultipartData("username", "smool-@ukr.net")
                        .with("password", "Ilikecs63")
                        .with("remember_me", "true")
                        .with("_csrf", xsrfHeader))
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE, "boundary=--------------------------289178681682133397753352")
                .retrieve();

        log.info(responseSpec.toString());

        ResponseEntity responseEntity = responseSpec.toBodilessEntity().block();

        log.info(responseEntity.toString());


        return null;
    }




}
