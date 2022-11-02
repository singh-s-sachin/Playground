package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OpenClosedBracket {
    public static boolean validate(String input)
    {
        Map<Character,Character> openVsClosed=new HashMap<>()
        {{
            put('{','}');
            put('(',')');
            put('[',']');
        }};
        Stack<Character> charStack=new Stack<>();
        for(char k : input.toCharArray())
        {
            if(!charStack.isEmpty() && openVsClosed.get(charStack.peek())==k)
            {
                charStack.pop();
            }
            else {
                charStack.push(k);
            }
        }
        return charStack.isEmpty();
    }
}
