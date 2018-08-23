package com.db.tdd;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class TaxCalculatorTest {

    @Test
    public void withNDS() {
        TaxCalculator taxCalculator = new TaxCalculator();

        NDSResolver mock = Mockito.mock(NDSResolver.class);
        Mockito.when(mock.getNDS()).thenReturn(0.18);
        taxCalculator.setResolver(mock);
        double withNDS = taxCalculator.withNDS(100);
        assertEquals(118, withNDS, 0.000001);
    }
}