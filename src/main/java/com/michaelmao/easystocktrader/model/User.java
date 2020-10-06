package com.michaelmao.easystocktrader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "EasyStockTrader")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable{

  private static final long serialVersionUID = 1373782236015769999L;

  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  private String username;

  @JsonIgnore
  private String password;
  private Date createDate;
  private Date updateDate;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<UserStock> stocks = new ArrayList<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<WatchList> watchLists = new ArrayList<WatchList>();

  public User() {
  }

  @JsonView(JsonViews.UserStockView.class)
  public List<UserStock> getStocks() {
    return stocks;
  }

  public void setStocks(List<UserStock> stocks) {
    this.stocks = stocks == null ? new ArrayList<>() : stocks;
  }

  @JsonView(JsonViews.UserWatchListView.class)
  public List<WatchList> getWatchLists() {
    return watchLists;
  }

  public void setWatchLists(List<WatchList> watchLists) {
    this.watchLists = watchLists;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @JsonView(JsonViews.UserView.class)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  @JsonView(JsonViews.UserView.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @JsonView(JsonViews.UserView.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
}
