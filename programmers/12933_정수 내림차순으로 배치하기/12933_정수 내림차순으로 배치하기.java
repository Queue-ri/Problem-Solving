import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(long n) {
        char[] chArr = String.valueOf(n).toCharArray();
        Integer[] intArr = new Integer[chArr.length];
        for (int i=0; i<chArr.length; ++i) {
            intArr[i] = chArr[i] - '0';
        }
        Arrays.sort(intArr, Comparator.reverseOrder());
        String ansStr = Arrays.stream(intArr).map(String::valueOf).collect(Collectors.joining());
        return Long.parseLong(ansStr);
    }
}