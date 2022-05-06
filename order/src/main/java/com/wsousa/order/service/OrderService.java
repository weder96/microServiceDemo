package com.wsousa.order.service;

import com.wsousa.order.dto.AccountingDTO;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<AccountingDTO> getDataAccounting(String idAccounting);
}
