package com.db.tdd;

import lombok.Setter;

public class TaxCalculator {

    @Setter
    private NDSResolver resolver;

    public double withNDS(double price) {
        double nds = resolver.getNDS();
        return  price * nds + price;
    }

}
