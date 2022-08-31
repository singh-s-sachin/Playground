package algorithm;

public class XSingleton {
    private static XSingleton xSingleton;

    int data;

    private XSingleton(int data) {
        this.data = data;
    }


    public static XSingleton getInstance() {
        if (xSingleton == null) {
            xSingleton = new XSingleton(2);
        }
        return xSingleton;
    }
}

