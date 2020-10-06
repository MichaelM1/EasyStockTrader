package com.michaelmao.easystocktrader.dataaccess;

import com.michaelmao.easystocktrader.model.Stock;
import com.michaelmao.easystocktrader.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockDaoImpl implements StockDao {
    @Autowired
    private StockRepository stockRepo;

    @Override
    public Stock getStock(Long stockId) {
        return stockRepo.getOne(stockId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepo.findAll();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockRepo.save(stock);
    }

    @Override
    public void deleteStock(Stock stock) {
        stockRepo.delete(stock);
    }
}
