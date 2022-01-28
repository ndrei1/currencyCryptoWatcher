package com.andrei.crypto_currency_watcher.repository;

import com.andrei.crypto_currency_watcher.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, Integer> {

    Crypto findBySymbol(String symbol);

}
