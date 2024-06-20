package com.codecipta.helper.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate<T> {
    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("isSuccess")
    private boolean isSuccess;

    @JsonProperty("responseMessage")
    private String responseMessage;

    @JsonProperty("responseData")
    private T responseData;
}
