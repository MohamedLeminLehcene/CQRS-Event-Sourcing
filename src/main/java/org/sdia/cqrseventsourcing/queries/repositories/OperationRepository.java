package org.sdia.cqrseventsourcing.queries.repositories;

import org.sdia.cqrseventsourcing.queries.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
