package com.michaelmao.easystocktrader.service;

import com.michaelmao.easystocktrader.dataaccess.StockDao;
import com.michaelmao.easystocktrader.model.Stock;
import com.michaelmao.easystocktrader.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class StockBOImpl implements StockBO {
    @Autowired
    private StockDao stockDao;

    @Override
    public Stock getStock(Long stockId) {
        return stockDao.getStock(stockId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockDao.getAllStocks();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockDao.createStock(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        Stock stockDB = stockDao.getStock(stock.getStockId());
        stockDB.setStockName(stock.getStockName());
        stockDB.setStockSymbol(stock.getStockSymbol());
        stockDB.setUpdateDate(new Date());
        return stockDao.updateStock(stock);
    }

    @Override
    public void deleteStock(Long stockId) {
        Stock stock = stockDao.getStock(stockId);

        if (stock != null)
            stockDao.deleteStock(stock);
    }
}
