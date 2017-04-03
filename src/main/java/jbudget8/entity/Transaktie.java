package jbudget8.entity;

import arch.entity.NonPersistendEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by geerc01 on 31-3-2017.
 */
public class Transaktie implements NonPersistendEntity {

    private Rekening rekening = new Rekening();
    private LocalDate transaktiedatum;
    private BigDecimal bedrag;
    private Rekening tegenrekening = new Rekening();
    private List<String> omschrijving = new ArrayList<>();

    public Transaktie(String rekeningnummer, LocalDate transaktiedatum, BigDecimal bedrag, String... omschrijvingsregels) {
        this.rekening.setNummer(rekeningnummer);
        this.transaktiedatum = transaktiedatum;
        this.bedrag = bedrag;
        Arrays.stream(omschrijvingsregels).forEach(t -> omschrijving.add(t));
    }

    public List<String> getOmschrijving() {
        return Collections.unmodifiableList(omschrijving);
    }

    public String getOmschrijvingAsString() {
        StringBuilder result = new StringBuilder();
        omschrijving.stream().forEach(regel -> result.append(regel).append(" "));
        return result.toString().trim();
    }

    public LocalDate getTransaktiedatum() {
        return transaktiedatum;
    }

    public BigDecimal getBedrag() {
        return bedrag;
    }

    public Rekening getTegenrekening() {
        return tegenrekening;
    }

    public void setTegenrekening(Rekening tegenrekening) {
        this.tegenrekening = tegenrekening;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }

    public void addOmschrijvingsregel(String regel) {
        omschrijving.add(regel);
    }

    public Integer getJaar() {
        return transaktiedatum.getYear();
    }

    public Integer getMaand() {
        return transaktiedatum.getMonthValue();
    }

    @Override
    public String toString() {
        return "Transaktie{" +
                "rekeningnummer='" + rekening.getNummer() + '\'' +
                ", transaktiedatum=" + transaktiedatum +
                ", bedrag=" + bedrag +
                ", tegenrekeningnummer='" + tegenrekening.getNummer() + '\'' +
                ", tegenrekeningnaam='" + tegenrekening.getNaam() + '\'' +
                ", omschrijving=" + getOmschrijvingAsString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaktie)) return false;

        Transaktie that = (Transaktie) o;

        if (!rekening.getNummer().equals(that.rekening.getNummer())) return false;
        if (!transaktiedatum.equals(that.transaktiedatum)) return false;
        if (!bedrag.equals(that.bedrag)) return false;
        if (tegenrekening.getNummer() != null ? !tegenrekening.getNummer().equals(that.tegenrekening.getNummer()) : that.tegenrekening.getNummer() != null)
            return false;
        if (tegenrekening.getNaam() != null ? !tegenrekening.getNaam().equals(that.tegenrekening.getNaam()) : that.tegenrekening.getNaam() != null)
            return false;
        return omschrijving.equals(that.omschrijving);

    }

    @Override
    public int hashCode() {
        int result = rekening.getNummer().hashCode();
        result = 31 * result + transaktiedatum.hashCode();
        result = 31 * result + bedrag.hashCode();
        return result;
    }

}
