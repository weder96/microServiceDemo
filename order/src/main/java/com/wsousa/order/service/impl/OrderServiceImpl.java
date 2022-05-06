package com.wsousa.order.service.impl;

import com.wsousa.order.dto.AccountingDTO;
import com.wsousa.order.http.client.AccountingClient;
import com.wsousa.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final AccountingClient accountingClient;

    public OrderServiceImpl(AccountingClient accountingClient) {
        this.accountingClient = accountingClient;
    }

    @Override
    public ResponseEntity<AccountingDTO> getDataAccounting(String idAccounting) {
        return accountingClient.getAccounting(idAccounting);
    }
}
