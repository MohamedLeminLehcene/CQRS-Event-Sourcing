package org.sdia.cqrseventsourcing.commands.dto;

import lombok.Data;

@Data
public class DebitAccountRequestDTO {
    private String accountId;
    private double amount;
    private String currency;
}
