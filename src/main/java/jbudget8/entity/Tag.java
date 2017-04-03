package jbudget8.entity;

import arch.entity.NonPersistendEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 03-04-17.
 */
public class Tag implements NonPersistendEntity {

    private String naam;
    private List<Transaktie> transakties = new ArrayList<>();

    public Tag(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
