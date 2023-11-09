package interview.birdeye;

public class SingleTonXee {
    private static SingleTonXee singleTonXeeInstance = null;

    int data;

    private SingleTonXee(int data) {
        this.data = data;
    }

    public static SingleTonXee getInstance() {
        if (singleTonXeeInstance == null) {
            singleTonXeeInstance = new SingleTonXee(12);
        }
        return singleTonXeeInstance;
    }
}
