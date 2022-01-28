package com.andrei.crypto_currency_watcher.service;

import com.andrei.crypto_currency_watcher.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CryptoPrice {

    public void priceCheck(List<User> userList) {
        for (User u : userList) {
            double percent = difference(u.getStartCryptoPrice(), u.getCrypto().getPrice_usd());
            if (Math.sqrt(Math.pow(percent, 2)) > 1) {
                log.warn(u.getCrypto().getSymbol() + " " + u.getName() + " " + percent + " %");
            }
        }
    }

    private double difference(double a, double b) {
        return 100 - b * 100 / a;
    }
}
