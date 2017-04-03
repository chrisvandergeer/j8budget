package jbudget8.entity;

import arch.entity.NonPersistendEntity;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by chris on 03-04-17.
 */
public class Transakties implements NonPersistendEntity {

    private List<Transaktie> wrappedTransakties = new ArrayList<>();
    private Map<String, Rekening> rekeningen = new HashMap<>();
    private Map<String, Rekening> tegenrekeningen = new HashMap<>();

    public Rekening getOrCreateRekening(String rekeningnummer) {
        if (rekeningen.containsKey(rekeningnummer)) {
            return rekeningen.get(rekeningnummer);
        }
        Rekening rekening = new Rekening(rekeningnummer);
        rekeningen.put(rekeningnummer, rekening);
        return rekening;
    }

    public Rekening getOrCreateTegenrekening(String rekeningnummer) {
        if (tegenrekeningen.containsKey(rekeningnummer)) {
            return tegenrekeningen.get(rekeningnummer);
        }
        Rekening rekening = new Rekening(rekeningnummer);
        tegenrekeningen.put(rekeningnummer, rekening);
        return rekening;
    }

    public void addTransakties(List<Transaktie> transakties) {
        boolean b = this.wrappedTransakties.addAll(transakties);
    }

    public List<Transaktie> getWrappedTransakties() {
        return Collections.unmodifiableList(this.wrappedTransakties);
    }

    public Stream<Transaktie> stream() {
        return wrappedTransakties.stream();
    }
}
