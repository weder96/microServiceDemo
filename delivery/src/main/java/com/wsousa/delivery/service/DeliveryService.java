package com.wsousa.delivery.service;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Mono;

public interface DeliveryService {

    Mono<JsonNode> getDataAccounting(String idAccounting);
}
