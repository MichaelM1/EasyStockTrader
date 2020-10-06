package com.michaelmao.easystocktrader.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.michaelmao.easystocktrader.model.JsonViews;
import com.michaelmao.easystocktrader.model.Stock;
import com.michaelmao.easystocktrader.service.StockBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockBO stockBO;

    @JsonView(JsonViews.StockView.class)
    @GetMapping(value = "/api/stocks")
    public List<Stock> getStocks() {
        return stockBO.getAllStocks();
    }

    @PostMapping(value = "/api/stocks")
    public Stock createStock(
            @RequestBody @JsonView(JsonViews.StockView.class)
                    Stock newStock) {
        return stockBO.createStock(newStock);
    }

    @JsonView(JsonViews.StockView.class)
    @GetMapping(value = "/api/stocks/{id}")
    public Stock getStock(
            @PathVariable Long id
    ) {
        return stockBO.getStock(id);
    }

    @PutMapping(value = "/api/stocks/{id}")
    public Stock updateStock(
            @PathVariable Long id,
            @RequestBody @JsonView(JsonViews.StockView.class)
                    Stock stock) throws Exception {
        if (stock.getStockId() != id) {
            throw new Exception("stock id does not match id in the stock");
        }
        return stockBO.updateStock(stock);
    }

    @DeleteMapping(value = "/api/stocks/{id}")
    public void deleteStock(
            @PathVariable Long id
    ) {
        stockBO.deleteStock(id);
    }

}
