package com.michaelmao.easystocktrader.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WatchListStockPK implements Serializable {

    private static final long serialVersionUID = 1458941637685736280L;

    private Long watchListId;
    private Long stockId;

    public WatchListStockPK() {
    }

    public Long getWatchListId() {
        return watchListId;
    }

    public void setWatchListId(Long watchListId) {
        this.watchListId = watchListId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof WatchListStockPK))
            return false;

        WatchListStockPK that = (WatchListStockPK) o;
        return Objects.equals(watchListId, that.watchListId) &&
                Objects.equals(stockId, that.stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchListId, stockId);
    }
}
