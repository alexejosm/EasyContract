package com.osmolovskyy.EasyContracts.person.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentBo {

    private Long id;
    private DebtBo debt;
    private BigDecimal amount;
    private LocalDate paymentDate;


}
