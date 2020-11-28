package com.cybrilla.bankaccountmanagement.repository;

import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
   // Optional<Account> findByAccountNumber(long account);

    Optional<Account> findByCustomerIdAndAccountType(long customerId, AccountType accountType);
}
