package com.wsousa.accounting.dto;

import lombok.Data;

@Data
public class AccountingDTO {
    private String id;
    private String name;
    private double value;
    private boolean isActive;
}
