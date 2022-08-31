package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PythagorasTriplet {
    public static List<Double> getTriplet(List<Double> values) {
        int len = values.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                Double hypotenuse = Math.sqrt(Math.pow(values.get(i), 2) + Math.pow(values.get(j), 2));
                if (values.contains(hypotenuse)) {
                    return Arrays.asList(values.get(i), values.get(j), hypotenuse);
                }
            }
        }
        return new ArrayList<>();
    }
}
