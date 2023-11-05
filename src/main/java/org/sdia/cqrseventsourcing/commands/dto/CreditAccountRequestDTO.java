package org.sdia.cqrseventsourcing.commands.dto;

import lombok.Data;

@Data
public class CreditAccountRequestDTO {
    private String accountId;
    private double amount;
    private String currency;
}
