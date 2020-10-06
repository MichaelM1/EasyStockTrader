package com.michaelmao.easystocktrader.service;

import com.michaelmao.easystocktrader.dataaccess.UserDao;
import com.michaelmao.easystocktrader.model.User;
import com.michaelmao.easystocktrader.model.UserStock;
import com.michaelmao.easystocktrader.model.WatchList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UserBOImpl implements UserBO {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Long userId) {
        return userDao.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        User userDB = userDao.getUser(user.getUserId());
        userDB.setUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        userDB.setUpdateDate(new Date());
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userDao.getUser(userId);

        if (user != null)
            userDao.deleteUser(user);
    }

    @Override
    public List<UserStock> findUserStocks(Long userId) {
        return userDao.findUserStocks(userId);
    }

    @Override
    public List<WatchList> findUserWatchList(Long userId) {
        return userDao.findUserWatchList(userId);
    }
}
