package arch.control;

/**
 * Created by chris on 03-04-17.
 */
public interface FluentController<IO, I> {

    IO execute(IO io, I i);
}
