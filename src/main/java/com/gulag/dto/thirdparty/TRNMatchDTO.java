package com.gulag.dto.thirdparty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TRNMatchDTO {

    BigInteger matchId;

    Timestamp timestamp;

    long durationMillis;

    @JsonProperty("attributes")
    private void unpackAttributes(Map<String, Object> attributes) {
        matchId = new BigInteger((String) attributes.get("id"));
    }

    @JsonProperty("metadata")
    private void unpackMetadata(Map<String, Object> metadata) {
        timestamp = new Timestamp((long) metadata.get("timestamp"));
        Map<String, Object> duration = (Map<String, Object>) metadata.get("duration");
        durationMillis = (long) duration.get("value");

    }
}
