package com.andrei.crypto_currency_watcher.repository;

import com.andrei.crypto_currency_watcher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}