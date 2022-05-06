package com.wsousa.delivery.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.wsousa.delivery.http.clients.AccoutingWebClient;
import com.wsousa.delivery.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final AccoutingWebClient accoutingWebClient;

    public DeliveryServiceImpl(AccoutingWebClient accoutingWebClient) {
        this.accoutingWebClient = accoutingWebClient;
    }

    @Override
    public Mono<JsonNode> getDataAccounting(String idAccounting) {
        return this.accoutingWebClient.getAccoutingById(idAccounting)
                .doOnError(error -> log.info("error "+ error))
                .map(response -> {return response;});
    }
}
