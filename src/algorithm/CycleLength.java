package algorithm;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class CycleLength {
    public static int compute(int[] arr, int startIndex){
        Map.Entry<String,Integer> hopsEntry = new AbstractMap.SimpleEntry<>("hop",0);
        return computeRec(arr,startIndex,startIndex,hopsEntry);
    }

    private static int computeRec(int[] arr, int startIndex, int currentIndex, Map.Entry<String, Integer> hopsEntry) {
        if(startIndex==currentIndex && hopsEntry.getValue()!=0)
        {
            return hopsEntry.getValue();
        }
        if(currentIndex>=arr.length)
        {
            return -1;
        }
        hopsEntry.setValue(hopsEntry.getValue()+1);
        return computeRec(arr,startIndex,arr[currentIndex],hopsEntry);
    }
}
