package arch.control;

/**
 * Created by geerc01 on 31-3-2017.
 */
public interface Controller<I, O> {

    public O execute(I input);
}
