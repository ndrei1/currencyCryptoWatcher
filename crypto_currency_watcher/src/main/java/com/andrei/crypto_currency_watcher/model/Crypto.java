package com.andrei.crypto_currency_watcher.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "crypto")
public class Crypto {
    @Id
    private Integer id;
    private String symbol;
    private Double price_usd;

    public Crypto(Integer id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", symbol='" + symbol + '\'';
    }
}
