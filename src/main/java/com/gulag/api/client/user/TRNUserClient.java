package com.gulag.api.client.user;

import com.gulag.dto.thirdparty.TRNRecentMatchDTO;
import com.gulag.parsers.JSONParser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TRNUserClient {

//    static String TRN_SEARCH_BY_ACTIID = "https://api.tracker.gg/api/v2/warzone/standard/matches/atvi/Smol%236665372?type=wz";
    static String TRN_SEARCH_BY_ACTIID = "https://api.tracker.gg/api/v2/warzone/standard/matches/atvi/%s?type=wz";

    JSONParser trnJSONRecentMatchParser;

    public Object doRequest(String unoTag) {

        String formattedUnoTag = String.format(TRN_SEARCH_BY_ACTIID, unoTag.replace("#", "%23"));

        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(formattedUnoTag);
        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

//        WebClient.ResponseSpec responseSpec = WebClient
//                .builder()
//                .uriBuilderFactory(uriBuilderFactory)
//                .baseUrl(formattedUnoTag)
//                .build()
//                .get()
//                .retrieve();
//
//        String json = responseSpec.bodyToMono(String.class).block();
        log.info(str);
        TRNRecentMatchDTO trnRecentMatchDTO = (TRNRecentMatchDTO) trnJSONRecentMatchParser.parse(str);
        log.info(trnRecentMatchDTO.toString());

        return trnRecentMatchDTO;
    }


    static String str = "{\"data\":{\"matches\":[{\"attributes\":{\"id\":\"6107148307478663711\",\"mapId\":\"mp_don4\",\"modeId\":\"br_brquads\",\"avgKd\":{\"kd\":1.27,\"pct\":86}}}],\"metadata\":{\"next\":1632952292999},\"paginationType\":\"Next\",\"requestingPlayerAttributes\":{\"platformUserIdentifier\":\"8cab09fb-4165-4b83-ad09-88d32be887b7\"},\"expiryDate\":\"2021-10-17T07:58:40.7200499+00:00\"}}";
}
