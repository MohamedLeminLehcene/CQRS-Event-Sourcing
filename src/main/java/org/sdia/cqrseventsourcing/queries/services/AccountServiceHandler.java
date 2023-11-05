package org.sdia.cqrseventsourcing.queries.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.sdia.cqrseventsourcing.enums.OperationType;
import org.sdia.cqrseventsourcing.events.AccountActivatedEvent;
import org.sdia.cqrseventsourcing.events.AccountCreatedEvent;
import org.sdia.cqrseventsourcing.events.AccountCreditedEvent;
import org.sdia.cqrseventsourcing.events.AccountDebitedEvent;
import org.sdia.cqrseventsourcing.queries.dto.GetAccountsByIdDTO;
import org.sdia.cqrseventsourcing.queries.dto.GetAllAccountsQueryDTO;
import org.sdia.cqrseventsourcing.queries.entities.Account;
import org.sdia.cqrseventsourcing.queries.entities.Operation;
import org.sdia.cqrseventsourcing.queries.repositories.AccountRepository;
import org.sdia.cqrseventsourcing.queries.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class AccountServiceHandler {

    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @EventHandler
    public void on(AccountCreatedEvent event){
        log.info("*******************************");
        log.info("AccountCreatedEvent received");
        Account account= new Account();
        account.setId(event.getId());
        account.setBalance(event.getInitialBalance());
        account.setCurrency(event.getCurrency());
        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent event){
        log.info("*******************************");
        log.info("AccountActivatedEvent received");
        Account account= accountRepository.findById(event.getId()).get();

        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountDebitedEvent event){
        log.info("*******************************");
        log.info("AccountDebitedEvent received");
        Account account= accountRepository.findById(event.getId()).get();
        Operation operation= new Operation();
        operation.setAmount(event.getAmount());
        operation.setDate(new Date());
        operation.setType(OperationType.DEBIT);
        operation.setAccount(account);
        operationRepository.save(operation);
        account.setBalance(account.getBalance()-event.getAmount());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountCreditedEvent event){
        log.info("*******************************");
        log.info("AccountCreditedEvent received");
        Account account= accountRepository.findById(event.getId()).get();
        Operation operation= new Operation();
        operation.setAmount(event.getAmount());
        operation.setDate(new Date());
        operation.setType(OperationType.CREDIT);
        operation.setAccount(account);
        operationRepository.save(operation);
        account.setBalance(account.getBalance()+event.getAmount());
        accountRepository.save(account);
    }
    @QueryHandler
    public List<Account> on(GetAllAccountsQueryDTO query){
        return accountRepository.findAll();
    }

    @QueryHandler
    public Account on(GetAccountsByIdDTO query){
        return accountRepository.findById(query.getId()).get();
    }
}
