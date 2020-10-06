package com.michaelmao.easystocktrader.repository;

import com.michaelmao.easystocktrader.model.UserStock;
import com.michaelmao.easystocktrader.model.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStockRepository extends JpaRepository<UserStock, Long> {
    List<UserStock> findByUserId(Long userId);
}
