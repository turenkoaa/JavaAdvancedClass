package com.db.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TaxCalculatorConfig.class)
public class TaxCalculatorTest {

    @Test
    public void withNDSUnitTest() {

        NDSResolver mock = Mockito.mock(NDSResolver.class);
        Mockito.when(mock.getNDS()).thenReturn(0.18);
        TaxCalculator taxCalculator = new TaxCalculator(mock);
        double withNDS = taxCalculator.withNDS(100);
        assertEquals(118, withNDS, 0.000001);
    }

    @Autowired
    TaxCalculator taxCalculator;

    @Test
    public void withNDSComponentTest() {
        double withNDS = taxCalculator.withNDS(100);
        assertEquals(118, withNDS, 0.000001);
    }

}