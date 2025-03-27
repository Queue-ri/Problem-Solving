import java.util.*;

class Solution {
    List<Integer> ansList = new ArrayList<>();
    int _n, _k;

    public void rcs(int num, int depth) {
        if (_n == depth) {
            ansList.add(num);
            return;
        }

        int lastDigit = num % 10;
        int cand1 = lastDigit - _k;
        int cand2 = lastDigit + _k;
        if (0 <= cand1) rcs(num*10+cand1, depth+1);
        if (cand1 < cand2 && cand2 < 10) rcs(num*10+cand2, depth+1);
    }

    public int[] numsSameConsecDiff(int n, int k) {
        _n = n;
        _k = k;
        for (int i = 1; i < 10; ++i) rcs(i, 1);

        return ansList.stream().mapToInt(i->i).toArray();
    }
}