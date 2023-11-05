package org.sdia.cqrseventsourcing.queries.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.sdia.cqrseventsourcing.queries.dto.GetAccountsByIdDTO;
import org.sdia.cqrseventsourcing.queries.dto.GetAllAccountsQueryDTO;
import org.sdia.cqrseventsourcing.queries.entities.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/accounts")
@AllArgsConstructor
@Slf4j
public class AccountQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/allAccounts")
    public List<Account> accountList(){
        List<Account> response= queryGateway.query(new GetAllAccountsQueryDTO(), ResponseTypes.multipleInstancesOf(Account.class)).join();
        return response;
    }

    @GetMapping("/byId/{id}")
    public Account getAccount(@PathVariable String id){
        Account response= queryGateway.query(new GetAccountsByIdDTO(id), ResponseTypes.instanceOf(Account.class)).join();
        return response;
    }
}
