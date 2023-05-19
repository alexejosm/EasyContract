package com.osmolovskyy.EasyContracts.dummy.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentBo {

    private Long id;
    private DebtBo debt;
    private BigDecimal amount;
    private LocalDate paymentDate;


}
