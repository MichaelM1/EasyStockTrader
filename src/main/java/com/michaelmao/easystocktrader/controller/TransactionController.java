package com.michaelmao.easystocktrader.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.michaelmao.easystocktrader.model.JsonViews;
import com.michaelmao.easystocktrader.model.Transaction;
import com.michaelmao.easystocktrader.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepo;

    @JsonView(JsonViews.TransactionView.class)
    @GetMapping(value = "/api/transactions")
    public List<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    @PostMapping(value = "/api/transactions")
    public Transaction createTransaction(
            @RequestBody @JsonView(JsonViews.TransactionView.class)
                    Transaction newTransaction) {
        return transactionRepo.save(newTransaction);
    }

    @JsonView(JsonViews.TransactionView.class)
    @GetMapping(value = "/api/transactions/{id}")
    public Transaction getTransaction(
            @PathVariable Long id
    ) {
        return transactionRepo.getOne(id);
    }

    @PutMapping(value = "/api/transactions/{id}")
    public Transaction updateTransaction(
            @PathVariable Long id,
            @RequestBody @JsonView(JsonViews.TransactionView.class)
                    Transaction transaction
    ) {
        Transaction transactionDB = transactionRepo.getOne(id);
        transactionDB.setTransactionPrice(transaction.getTransactionPrice());
        transactionDB.setNumShares(transaction.getNumShares());
        transactionDB.setStock(transaction.getStock());
        transactionDB.setUpdateDate(new Date());
        return transactionRepo.save(transactionDB);
    }

    @DeleteMapping(value = "/api/transactions/{id}")
    public void deleteTransaction(
            @PathVariable Long id
    ) {
        transactionRepo.deleteById(id);
    }

}
