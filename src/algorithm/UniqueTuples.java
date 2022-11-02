package algorithm;

import java.util.HashSet;
import java.util.Set;

public class UniqueTuples {
    //Get unique tuples from string

    public static Set<String> getUniqueTuples(String input, int len)
    {
        Set<String> tuples = new HashSet<>();
        int ipLen = input.length();
        for (int i=0;i<ipLen-len+1;i++)
        {
            tuples.add(input.substring(i,i+len));
        }
        return tuples;
    }
}
