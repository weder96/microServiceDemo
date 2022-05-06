package com.wsousa.accounting.controller;

import com.wsousa.accounting.dto.AccountingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/accounting")
@Slf4j
public class AccountingController {

    @GetMapping(value="/{id_accounting}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountingDTO> list(@PathVariable(name = "id_accounting") String id){
        AccountingDTO accountingDTO = new AccountingDTO();
        accountingDTO.setId(id);
        accountingDTO.setName("Tax");
        accountingDTO.setValue(2000.34);
        accountingDTO.setActive(true);
        return  new ResponseEntity<AccountingDTO>(accountingDTO, HttpStatus.OK);
    }

}
