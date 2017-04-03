package jbudget8.control;

import arch.control.Controller;
import jbudget8.entity.Transaktie;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chris on 01-04-17.
 */
public class TotaalPerMaandCalculator implements Controller<Stream<Transaktie>, Map<String, BigDecimal>> {

    @Override
    public Map<String, BigDecimal> execute(Stream<Transaktie> transakties) {
        return transakties.collect(Collectors.groupingBy(
                t -> t.getJaar() + "-" + t.getMaand(),
                Collectors.reducing(BigDecimal.ZERO, Transaktie::getBedrag, BigDecimal::add)
        ));
    }

    private Map<String, BigDecimal> oldWayToDoIt(Stream<Transaktie> transakties) {
        Map<String, BigDecimal> result = new HashMap<>();
        for (Transaktie t : transakties.collect(Collectors.toList())) {
            String key = t.getJaar() + "-" + t.getMaand();
            BigDecimal bedrag = t.getBedrag();
            if (result.containsKey(key)) {
                bedrag = bedrag.add(result.get(key));
            }
            result.put(key, bedrag);
        }
        return result;
    }
}
