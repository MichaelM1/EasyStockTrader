package com.michaelmao.easystocktrader.service;

import com.michaelmao.easystocktrader.model.User;
import com.michaelmao.easystocktrader.model.UserStock;
import com.michaelmao.easystocktrader.model.WatchList;

import java.util.List;

public interface UserBO {
    User getUser(Long userId);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    List<UserStock> findUserStocks(Long userId);

    List<WatchList> findUserWatchList(Long userId);
}
