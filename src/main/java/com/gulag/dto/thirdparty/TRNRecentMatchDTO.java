package com.gulag.dto.thirdparty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TRNRecentMatchDTO {

    Timestamp expiryDate;

    List<Object> matches;

    Timestamp next;

    @JsonProperty("metadata")
    private void enrich(Map<String, Object> metadata) {
        next = new Timestamp((long)metadata.get("next"));
    }

}
