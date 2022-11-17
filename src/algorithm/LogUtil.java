package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogUtil {
    public static List<String> getMaximumConsumer(List<String> logs) {
        int maxCount = 0;
        Map<String, Integer> consumerIPVsCounts = new HashMap<>();
        List<String> maxConsumer = new ArrayList<>();
        for (String log : logs) {
            String currentIP = log.split(" - ")[0];
            int count = consumerIPVsCounts.getOrDefault(currentIP, 0);
            count++;
            consumerIPVsCounts.put(currentIP, count);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        for(Map.Entry<String, Integer> entry: consumerIPVsCounts.entrySet())
        {
            if(entry.getValue()==maxCount)
            {
                maxConsumer.add(entry.getKey());
            }
        }

        return maxConsumer;
    }
}
