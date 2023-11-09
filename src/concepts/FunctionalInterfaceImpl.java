package concepts;

public class FunctionalInterfaceImpl implements FunctionalInterface{

    @Override
    public boolean isAcceptable(Integer n) {
        return n%2==0;
    }
}
