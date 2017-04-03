package jbudget8.control;

import jbudget8.entity.Transaktie;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chris on 01-04-17.
 */
public class TotaalPerMaandCalculatorTest {

    @Test
    public void test() {
        Stream<Transaktie> transakties = new ImportTransaktieController().execute("csvinput.csv")
                .getWrappedTransakties().stream();
        Map<String, BigDecimal> result = new TotaalPerMaandCalculator().execute(transakties);
        assertEquals(new BigDecimal("-219.76"), result.get("2015-8"));
        assertEquals(new BigDecimal("-253.24"), result.get("2015-12"));
        assertEquals(new BigDecimal("724.96"), result.get("2016-7"));
        assertEquals(new BigDecimal("-33.89"), result.get("2016-8"));
    }

}