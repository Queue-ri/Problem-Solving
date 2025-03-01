import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5}; // 5
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        int sa = 0;
        int sb = 0;
        int sc = 0;
        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == a[i%5]) ++sa;
            if (answers[i] == b[i%8]) ++sb;
            if (answers[i] == c[i%10]) ++sc;
        }
        
        int mx = Math.max(sa, Math.max(sb, sc));
        List<Integer> ansList = new ArrayList<>();
        if (sa == mx) ansList.add(1);
        if (sb == mx) ansList.add(2);
        if (sc == mx) ansList.add(3);
        
        return ansList.stream().mapToInt(i->i).toArray();
    }
}