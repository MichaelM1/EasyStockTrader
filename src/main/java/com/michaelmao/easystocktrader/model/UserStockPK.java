package com.michaelmao.easystocktrader.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserStockPK implements Serializable {
    private static final long serialVersionUID = 2855550360753599418L;

    private Long userId;

    private Long stockId;

    public UserStockPK() {}

    public UserStockPK(Long userId, Long stockId) {
        this.userId = userId;
        this.stockId = stockId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

        if (!(o instanceof UserStockPK))
            return false;

        UserStockPK that = (UserStockPK) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(stockId, that.stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, stockId);
    }

}
