package com.andrei.crypto_currency_watcher.service;

import com.andrei.crypto_currency_watcher.model.Crypto;
import com.andrei.crypto_currency_watcher.model.User;
import com.andrei.crypto_currency_watcher.repository.CryptoRepository;
import com.andrei.crypto_currency_watcher.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CryptoService {

    private final CryptoInfo cryptoInfo;
    private final CryptoRepository cryptoRepository;
    private final CryptoPrice cryptoPrice;
    private final UserRepository userRepository;

    public CryptoService(CryptoInfo cryptoInfo, CryptoRepository cryptoRepository, UserRepository userRepository, CryptoPrice cryptoPrice) {
        this.cryptoInfo = cryptoInfo;
        this.cryptoRepository = cryptoRepository;
        this.cryptoPrice = cryptoPrice;
        this.userRepository = userRepository;
    }

    private void addData() {
        List<Crypto> data = new ArrayList<>();
        data.add(new Crypto(90, "BTC"));
        data.add(new Crypto(80, "ETH"));
        data.add(new Crypto(48543, "SOL"));
        cryptoRepository.saveAll(data);
    }

    @Scheduled(fixedRate = 60000)
    public void cryptoObserver() {
        if (cryptoRepository.findAll().size() == 0) {
            addData();
        }
        List<User> allUser = userRepository.findAll();
        List<Crypto> allCrypto = cryptoRepository.findAll();

        cryptoRepository.saveAll(cryptoInfo.updatePrice(allCrypto));
        cryptoPrice.priceCheck(allUser);
    }
}
