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
public class WatchListStock implements Serializable {

  private static final long serialVersionUID = 1458941637685736280L;

  @EmbeddedId
  private WatchListStockPK id = new WatchListStockPK();

  @ManyToOne
  @MapsId("watchListId")
  @JoinColumn(name = "WatchListId")
  private WatchList watchList;

  @ManyToOne
  @MapsId("stockId")
  @JoinColumn(name = "StockId")
  private Stock stock;

  public WatchListStock() {
  }

  @JsonIgnore
  public WatchListStockPK getId() {
    return id;
  }

  public void setId(WatchListStockPK id) {
    this.id = id == null ? new WatchListStockPK() : id;
  }

  @JsonIgnore
  public WatchList getWatchList() {
    return watchList;
  }

  public void setWatchList(WatchList watchList) {
    this.watchList = watchList;
  }

  @JsonView(JsonViews.WatchListView.class)
  public Stock getStock() {
    return stock;
  }

  public void setStock(Stock stock) {
    this.stock = stock;
  }
}
