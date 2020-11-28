package com.cybrilla.bankaccountmanagement.repository;

import com.cybrilla.bankaccountmanagement.model.Payee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayeeRepo extends JpaRepository<Payee, Long> {

    Optional<Payee> findByPayeeAccountId(long accountId);
}
