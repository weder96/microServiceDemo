package com.wsousa.order.controller;

import com.wsousa.order.dto.AccountingDTO;
import com.wsousa.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/order")
@Slf4j
//@RequiredArgsConstructor(onConstructor = @__(@Autowired)
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountingDTO> list(){
        ResponseEntity<AccountingDTO> accountingDTO = this.orderService.getDataAccounting("nxvfg23");
        return  accountingDTO;
    }

}
