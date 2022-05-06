package com.wsousa.order.http.client;

import com.wsousa.order.dto.AccountingDTO;
import com.wsousa.order.http.client.configuration.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accountingClient", url = "${api.url.accounting}", configuration = ClientConfiguration.class)
public interface AccountingClient {
    @GetMapping(value="/{id_accounting}",consumes = "application/json")
    ResponseEntity<AccountingDTO> getAccounting(@PathVariable("id_accounting") String id_accounting);
}
