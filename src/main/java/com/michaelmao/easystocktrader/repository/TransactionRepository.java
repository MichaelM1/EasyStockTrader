package com.michaelmao.easystocktrader.repository;

import com.michaelmao.easystocktrader.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
