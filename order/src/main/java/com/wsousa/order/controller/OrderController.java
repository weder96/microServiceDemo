package com.wsousa.order.controller;

import com.wsousa.order.dto.AccountingDTO;
import com.wsousa.order.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("v1/order")
@Slf4j
//@RequiredArgsConstructor(onConstructor = @__(@Autowired)
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    private Map<String , AccountingDTO> CACHE = new HashMap<>();

    @CircuitBreaker(name = "orderCB", fallbackMethod = "fallback")
    @GetMapping(path = "/{id_accounting}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountingDTO list(@PathVariable(name = "id_accounting") String id){
        ResponseEntity<AccountingDTO> accountingDTO = this.orderService.getDataAccounting(id);
        CACHE.put(id, accountingDTO.getBody());
        return  accountingDTO.getBody();
    }

    private AccountingDTO fallback(String idAccounting, IllegalArgumentException e) {
        log.info("FallBack  Call");
        return CACHE.getOrDefault(idAccounting, new AccountingDTO());
    }

}
