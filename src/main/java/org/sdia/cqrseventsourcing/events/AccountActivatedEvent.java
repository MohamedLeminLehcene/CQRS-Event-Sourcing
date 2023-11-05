package org.sdia.cqrseventsourcing.events;

import lombok.Getter;
import org.sdia.cqrseventsourcing.enums.AccountStatus;

public class AccountActivatedEvent extends  BaseEvent<String>{

    @Getter private AccountStatus status;

    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status=status;
    }
}
