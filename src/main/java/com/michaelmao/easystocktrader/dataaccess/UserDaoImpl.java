package com.michaelmao.easystocktrader.dataaccess;

import com.michaelmao.easystocktrader.model.User;
import com.michaelmao.easystocktrader.model.UserStock;
import com.michaelmao.easystocktrader.model.WatchList;
import com.michaelmao.easystocktrader.repository.UserRepository;
import com.michaelmao.easystocktrader.repository.UserStockRepository;
import com.michaelmao.easystocktrader.repository.WatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserStockRepository userStockRepo;

    @Autowired
    private WatchListRepository watchListRepo;

    @Override
    public User getUser(Long userId) {
        return userRepo.getOne(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public List<UserStock> findUserStocks(Long userId) {
        return userStockRepo.findByUserId(userId);
    }

    @Override
    public List<WatchList> findUserWatchList(Long userId) {
        return watchListRepo.findByUserId(userId);
    }
}
