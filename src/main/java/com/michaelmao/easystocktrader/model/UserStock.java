package com.michaelmao.easystocktrader.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "EasyStockTrader")
@DynamicInsert
@DynamicUpdate
public class UserStock implements Serializable {

    private static final long serialVersionUID = -7499764340807793696L;

    @EmbeddedId
    private UserStockPK id = new UserStockPK();

    private Long userId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "StockId")
    private Stock stock;

    private Long totalShares;

    public UserStock() {
    }

    @JsonView(JsonViews.UserStockView.class)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public UserStockPK getId() {
        return id;
    }

    public void setId(UserStockPK id) {
        this.id = id == null ? new UserStockPK() : id;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        getId().setUserId(user.getUserId());
    }

    @JsonView(JsonViews.UserStockView.class)
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
        getStock().setStockId(stock.getStockId());
    }

    @JsonView(JsonViews.UserStockView.class)
    public Long getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(Long totalShares) {
        this.totalShares = totalShares;
    }
}
