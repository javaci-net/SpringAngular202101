package lambda;

@FunctionalInterface
public interface StateChangeListener {

    public void onStateChange(State oldState, State newState);

}
