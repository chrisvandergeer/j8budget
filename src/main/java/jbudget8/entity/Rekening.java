package jbudget8.entity;

import arch.entity.NonPersistendEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chris on 02-04-17.
 */
public class Rekening implements NonPersistendEntity {

    private String naam;
    private String nummer;
    private Set<Transaktie> transakties = new HashSet<Transaktie>();

    public Rekening() {
        super();
    }

    public Rekening(String rekeningnummer) {
        this();
        this.nummer = rekeningnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public void addTransaktie(Transaktie transaktie) {
        this.transakties.add(transaktie);
    }

    public Set<Transaktie> getTransakties() {
        return Collections.unmodifiableSet(transakties);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rekening rekening = (Rekening) o;

        return nummer.equals(rekening.nummer);
    }

    @Override
    public int hashCode() {
        return nummer.hashCode();
    }
}
