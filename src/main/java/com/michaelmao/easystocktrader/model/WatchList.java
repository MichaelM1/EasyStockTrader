package com.michaelmao.easystocktrader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "EasyStockTrader")
@DynamicInsert
@DynamicUpdate
public class WatchList implements Serializable {

  private static final long serialVersionUID = -1239243434835289732L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long watchListId;

  private Long userId;

  @ManyToOne
  @JoinColumn(name="UserId")
  private User user;

  @OneToMany(mappedBy = "watchList", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WatchListStock> stocks = new ArrayList<>();

  private String watchListName;
  private Date createDate;
  private Date updateDate;

  public Long getWatchListId() {
    return watchListId;
  }

  public void setWatchListId(Long watchListId) {
    this.watchListId = watchListId;
  }

  @JsonView(value = {JsonViews.UserWatchListView.class, JsonViews.WatchListView.class})
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @JsonIgnore
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @JsonView(JsonViews.WatchListView.class)
  public List<WatchListStock> getStocks() {
    return stocks;
  }

  public void setStocks(List<WatchListStock> stocks) {
    this.stocks = stocks;
  }

  public String getWatchListName() {
    return watchListName;
  }

  public void setWatchListName(String watchListName) {
    this.watchListName = watchListName;
  }

  @JsonView(JsonViews.WatchListView.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @JsonView(JsonViews.WatchListView.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

}
