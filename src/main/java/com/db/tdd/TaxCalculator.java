package com.db.tdd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaxCalculator {

    private final NDSResolver resolver;

    public double withNDS(double price) {
        double nds = resolver.getNDS();
        return  price * nds + price;
    }

}
