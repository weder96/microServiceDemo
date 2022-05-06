package com.wsousa.delivery.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.wsousa.delivery.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/delivery")
@Slf4j
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> list(){
       Mono<JsonNode> result = this.deliveryService.getDataAccounting("nxvfg23");
        return ResponseEntity.ok(result.block());
    }
}
