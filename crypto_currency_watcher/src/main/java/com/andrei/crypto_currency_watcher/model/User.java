package com.andrei.crypto_currency_watcher.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crypto_id", referencedColumnName = "id")
    private Crypto crypto;
    private double startCryptoPrice;

    public User(String name, Crypto crypto, double startCryptoPrice) {
        this.name = name;
        this.crypto = crypto;
        this.startCryptoPrice = startCryptoPrice;
    }
}
