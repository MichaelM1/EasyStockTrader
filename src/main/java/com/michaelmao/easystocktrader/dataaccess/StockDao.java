package com.michaelmao.easystocktrader.dataaccess;

import com.michaelmao.easystocktrader.model.Stock;

import java.util.List;

public interface StockDao {
    Stock getStock(Long stockId);
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    Stock updateStock(Stock stock);
    void deleteStock(Stock stock);
}
