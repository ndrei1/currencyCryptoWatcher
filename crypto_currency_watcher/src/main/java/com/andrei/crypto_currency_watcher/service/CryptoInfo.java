package com.andrei.crypto_currency_watcher.service;

import com.andrei.crypto_currency_watcher.model.Crypto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CryptoInfo {

    private final RestTemplate restTemplate;

    public CryptoInfo(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private Crypto takeCurrentPrice(int id) {
        String url = "https://api.coinlore.net/api/ticker/?id=" + id;
        Crypto[] cryptos = restTemplate.getForObject(url, Crypto[].class);
        return Objects.requireNonNull(cryptos)[0];
    }

    public List<Crypto> updatePrice(List<Crypto> cryptoList) {
        List<Crypto> newList = new ArrayList<>();
        for (Crypto c : cryptoList) {
            newList.add(takeCurrentPrice(c.getId()));
        }
        return newList;
    }

}
