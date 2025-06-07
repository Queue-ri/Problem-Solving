import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int maxTrial = queue1.length * 3;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        long s1 = 0;
        long s2 = 0;
        for (int i : queue1) {
            q1.add(i);
            s1 += i;
        }
        for (int i : queue2) {
            q2.add(i);
            s2 += i;
        }
        
        long total = s1 + s2;
        if ((total & 1) == 1) return -1;
        long half = total >> 1;
        
        for (int t = 0; t < maxTrial; ++t) {
            if (s1 < s2) {
                int k = q2.poll();
                q1.add(k);
                s1 += k;
                s2 -= k;
            }
            else if (s2 < s1) {
                int k = q1.poll();
                q2.add(k);
                s2 += k;
                s1 -= k;
            }
            else {
                return t;
            }
        }
        
        return -1;
    }
}