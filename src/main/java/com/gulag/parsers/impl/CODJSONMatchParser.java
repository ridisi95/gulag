package com.gulag.parsers.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gulag.dto.thirdparty.CodMatchDTO;
import com.gulag.dto.thirdparty.CodPlayerDTO;
import com.gulag.parsers.JSONParser;
import com.jayway.jsonpath.JsonPath;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

import static org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR;

@Component("codJSONMatchParser")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CODJSONMatchParser implements JSONParser {

    static String ROOT_JSON_PATH = "$.data.allPlayers[*]";
    static String FIRST_ELEMENT_JSON_PATH = "[0]";

    @NonFinal
    String convertedJson;

    public CODJSONMatchParser() {
        convertedJson = null;
    }

    @Override
    public CodMatchDTO parse(String json) {

        convertedJson = JsonPath.parse(json).read(ROOT_JSON_PATH).toString();

        List<CodPlayerDTO> playerDTOList = null;
        try {
            playerDTOList = new ObjectMapper().readValue(convertedJson, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return CodMatchDTO.builder()
                .matchID(new BigInteger(parseField("matchID")))
                .utcStartSeconds(Integer.parseInt(parseField("utcStartSeconds")))
                .utcEndSeconds(Integer.parseInt(parseField("utcEndSeconds")))
                .duration(Integer.parseInt(parseField("duration")))
                .map(parseField("map"))
                .mode(parseField("mode"))
                .gameType(parseField("gameType"))
                .playerCount(Short.parseShort(parseField("playerCount")))
                .allPlayers(playerDTOList)
                .build();
    }

    private String parseField(String fieldName) {
        return JsonPath.parse(convertedJson)
                .read(FIRST_ELEMENT_JSON_PATH + PACKAGE_SEPARATOR + fieldName).toString();
    }
}
