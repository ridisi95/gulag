package com.gulag.services.impl;

import com.gulag.dto.CodMatchDTO;
import com.gulag.entity.MatchEntity;
import com.gulag.mapper.CodMatchMapper;
import com.gulag.parsers.CodJSONParser;
import com.gulag.repos.MatchRepository;
import com.gulag.services.MatchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigInteger;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    static String GET_MATCH_RESULT_URL = "https://my.callofduty.com/api/" +
            "papi-client/crm/cod/v2/title/mw/platform/battle/fullMatch/wz/%d/en";
    // It is roughly 1 mb
    static int MAX_IN_MEMORY_SIZE = 1 * 1024 * 1024;

    CodJSONParser codJSONParser;
    CodMatchMapper codMatchMapper;
    MatchRepository matchRepository;

    public MatchEntity fetchMatchFromCod(BigInteger id) {

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(MAX_IN_MEMORY_SIZE)).build();

        WebClient.ResponseSpec responseSpec = WebClient
                .builder()
                .baseUrl(String.format(GET_MATCH_RESULT_URL, id))
                .exchangeStrategies(exchangeStrategies)
                .build()
                .get()
                .retrieve();

        String json = responseSpec.bodyToMono(String.class).block();
        CodMatchDTO codMatchDTO = (CodMatchDTO)codJSONParser.parse(json);

        return  codMatchMapper.mapToEntity(codMatchDTO);
    }

    @Override
    public MatchEntity save(MatchEntity matchEntity) {
        return matchRepository.save(matchEntity);
    }
}
