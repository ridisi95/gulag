package com.gulag.parsers.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gulag.dto.thirdparty.TRNRecentMatchDTO;
import com.gulag.parsers.JSONParser;
import com.jayway.jsonpath.JsonPath;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Component;

@Component("trnJSONRecentMatchParser")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TRNJSONRecentMatchParser implements JSONParser {

    static String ROOT_JSON_PATH = "$.data";

    @NonFinal
    String convertedJson;

    public TRNJSONRecentMatchParser() {
        convertedJson = null;
    }

    @Override
    public TRNRecentMatchDTO parse(String json) {

        convertedJson = JsonPath.parse(json).read(ROOT_JSON_PATH, JSONObject.class).toJSONString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        TRNRecentMatchDTO trnRecentMatchDTO = null;
        try {
            trnRecentMatchDTO = new ObjectMapper().readValue(convertedJson, TRNRecentMatchDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return trnRecentMatchDTO;
    }
}
