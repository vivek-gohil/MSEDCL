package com.msedcl.main.transaction.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msedcl.main.transaction.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByAccountId(Integer accountId);

	int countByTransactionDate(LocalDate transactionDate);
}
