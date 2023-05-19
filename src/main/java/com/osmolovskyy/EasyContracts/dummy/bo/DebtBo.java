package com.osmolovskyy.EasyContracts.dummy.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
