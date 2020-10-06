package com.michaelmao.easystocktrader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(schema = "EasyStockTrader")
@DynamicInsert
@DynamicUpdate
public class Transaction implements Serializable {

  private static final long serialVersionUID = 8853971319232262294L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transactionId;

  @ManyToOne
  @JoinColumn(name="UserId")
  private User user;

  @ManyToOne
  @JoinColumn(name="StockId")
  private Stock stock;

  private BigDecimal transactionPrice;
  private Long numShares;
  private String orderType;
  private Date createDate;
  private Date updateDate;


  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Stock getStock() {
    return stock;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }

  private String getStockSymbol() {
    if (this.stock != null)
      return stock.getStockSymbol();
    return null;
  }

  public BigDecimal getTransactionPrice() {
    return transactionPrice;
  }

  public void setTransactionPrice(BigDecimal transactionPrice) {
    this.transactionPrice = transactionPrice;
  }


  public Long getNumShares() {
    return numShares;
  }

  public void setNumShares(Long numShares) {
    this.numShares = numShares;
  }


  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

}
