package com.osmolovskyy.EasyContracts.person.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DebtBo {
    private Long id;
    private PersonBo creditor;
    private ProviderBo provider;
    private BigDecimal amount;
    private LocalDate started;
    private boolean active;


}
