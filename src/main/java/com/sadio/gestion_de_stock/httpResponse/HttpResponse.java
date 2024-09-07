package com.sadio.gestion_de_stock.httpResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class HttpResponse {

    private int code;
    private LocalDateTime localDateTime;
    private String message;
    private Map<String, ?> data;
    private Map<String, ?> error;
}
