package com.michaelmao.easystocktrader.repository;

import com.michaelmao.easystocktrader.model.User;
import com.michaelmao.easystocktrader.model.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchListRepository extends JpaRepository<WatchList, Long> {
    List<WatchList> findByUserId(Long userId);
}
