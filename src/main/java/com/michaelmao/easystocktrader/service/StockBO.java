package com.michaelmao.easystocktrader.service;

import com.michaelmao.easystocktrader.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StockBO {
    Stock getStock(Long stockId);
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    Stock updateStock(Stock stock);
    void deleteStock(Long stockId);
}
