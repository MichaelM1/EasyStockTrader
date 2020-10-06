package com.michaelmao.easystocktrader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exchange")
@DynamicInsert
@DynamicUpdate
public class Exchange implements Serializable {

  private static final long serialVersionUID = -6803568223597031567L;

  @Id
  private Long exchangeId;
  private String exchangeName;
  private String exchangeDescription;
  private Date createDate;
  private Date updateDate;


  public Long getExchangeId() {
    return exchangeId;
  }

  public void setExchangeId(Long exchangeId) {
    this.exchangeId = exchangeId;
  }


  public String getExchangeName() {
    return exchangeName;
  }

  public void setExchangeName(String exchangeName) {
    this.exchangeName = exchangeName;
  }

  @JsonIgnore
  public String getExchangeDescription() {
    return exchangeDescription;
  }

  public void setExchangeDescription(String exchangeDescription) {
    this.exchangeDescription = exchangeDescription;
  }

  @JsonIgnore
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @JsonIgnore
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

}
