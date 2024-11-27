import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted(new CustomComp(n)).toArray(String[]::new);
    }
    
    private class CustomComp implements Comparator<String> {
        int n;
        
        CustomComp(int n) {this.n = n;}
        
        @Override
        public int compare(String a, String b) {
            char ca = a.charAt(n);
            char cb = b.charAt(n);
            if (ca > cb) return 1;
            else if (ca == cb) return a.compareTo(b);
            else return -1;
        }
    }
}