import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (st.isEmpty() || st.peek() != ch) st.push(ch);
            else st.pop();
        }
        
        return st.isEmpty() ? 1 : 0;
    }
}