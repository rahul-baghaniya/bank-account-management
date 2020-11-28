package com.cybrilla.bankaccountmanagement.repository;

import com.cybrilla.bankaccountmanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findByAccountId(long accountId);
}
