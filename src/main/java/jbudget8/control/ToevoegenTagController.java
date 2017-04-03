package jbudget8.control;

import arch.control.FluentController;
import jbudget8.entity.Transaktie;

import java.util.stream.Stream;

/**
 * Created by chris on 03-04-17.
 */
public class ToevoegenTagController implements FluentController<Stream<Transaktie>, String> {

    @Override
    public Stream<Transaktie> execute(Stream<Transaktie> transakties, String tagNaam) {
//        if (transakties.anyMatch(t -> t.hasTag(tagNaam))) {
//            transakties.filter(t -> t.getTag(tagNaam)).findFirst().get().getTag(tagNaam);
//        }
        return transakties;
    }
}
