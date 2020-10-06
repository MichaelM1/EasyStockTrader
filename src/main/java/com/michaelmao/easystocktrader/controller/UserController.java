package com.michaelmao.easystocktrader.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.michaelmao.easystocktrader.model.JsonViews;
import com.michaelmao.easystocktrader.model.User;
import com.michaelmao.easystocktrader.model.UserStock;
import com.michaelmao.easystocktrader.model.WatchList;
import com.michaelmao.easystocktrader.repository.WatchListRepository;
import com.michaelmao.easystocktrader.service.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserBO userBO;

    @Autowired
    private WatchListRepository watchListRepo;

    @JsonView(JsonViews.UserView.class)
    @GetMapping(value = "/api/users")
    public List<User> getUsers() {
        return userBO.getAllUsers();
    }

    @PostMapping(value = "/api/users")
    public User createUser(
            @RequestBody @JsonView(JsonViews.UserView.class)
                    User newUser) {
        return userBO.createUser(newUser);
    }

    @JsonView(JsonViews.UserView.class)
    @GetMapping(value = "/api/users/{id}")
    public User getUser(
            @PathVariable Long id
    ) {
        return userBO.getUser(id);
    }

    @PutMapping(value = "/api/users/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody @JsonView(JsonViews.UserView.class)
                    User user) throws Exception {
        if (user.getUserId() != id) {
            throw new Exception("user id does not match id in the user");
        }
        return userBO.updateUser(user);
    }

    @DeleteMapping(value = "/api/users/{id}")
    public void deleteUser(
            @PathVariable Long id
    ) {
        userBO.deleteUser(id);
    }

    @JsonView(JsonViews.WatchListView.class)
    @GetMapping(value = "/api/users/{id}/watchlist")
    public List<WatchList> getUserWatchList(
            @PathVariable Long id
    ) {
        return userBO.findUserWatchList(id);
    }

    @JsonView(JsonViews.WatchListView.class)
    @GetMapping(value = "/api/users/{id}/watchlist/{wid}")
    public WatchList getUserWatchList(
            @PathVariable Long id,
            @PathVariable Long wid
    ) throws Exception {
        WatchList watchList = watchListRepo.getOne(wid);
        if (watchList != null && watchList.getUserId() == id)
            return watchList;

        throw new Exception("cannot find the watch list");
    }

    @JsonView(JsonViews.UserStockView.class)
    @GetMapping(value = "/api/users/{id}/stocks")
    public List<UserStock> getUserStocks(
            @PathVariable Long id
    ) {
        return userBO.findUserStocks(id);
    }
}
