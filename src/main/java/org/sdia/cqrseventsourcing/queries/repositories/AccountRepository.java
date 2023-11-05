package org.sdia.cqrseventsourcing.queries.repositories;

import org.sdia.cqrseventsourcing.queries.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
