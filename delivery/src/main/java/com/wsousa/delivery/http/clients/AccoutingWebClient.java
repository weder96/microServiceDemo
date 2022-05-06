package com.wsousa.delivery.http.clients;

import com.fasterxml.jackson.databind.JsonNode;
import com.wsousa.delivery.exception.ApiNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AccoutingWebClient {
    @Value("${api.url.accounting}") private final String accoutingUrl;

    private WebClient.Builder webClientBuilder;

    public AccoutingWebClient(@Value("${api.url.accounting}") String accoutingUrl,
                              WebClient.Builder webClientBuilder) {
        this.accoutingUrl = accoutingUrl;
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<JsonNode> getAccoutingById(String idAccouting) {
        return webClientBuilder
                .baseUrl(accoutingUrl)
                .build()
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/{idAccouting}")
                                .build(idAccouting))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new ApiNotFoundException(error.toString())))
                .onStatus(HttpStatus::is5xxServerError, error -> Mono.error(new ApiNotFoundException(error.toString())))
                .bodyToMono(JsonNode.class)
                .onErrorMap((Throwable error) -> error);
    }
}
