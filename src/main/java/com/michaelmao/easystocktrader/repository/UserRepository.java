package com.michaelmao.easystocktrader.repository;

import com.michaelmao.easystocktrader.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
