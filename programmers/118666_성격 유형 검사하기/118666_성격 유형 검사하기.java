import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> typeMap = new HashMap<>();
        String types = "RTCFJMAN";
        for (char ch : types.toCharArray())
            typeMap.put(String.valueOf(ch), 0);
        
        // calc score
        for (int i = 0; i < survey.length; ++i) {
            switch (choices[i]) {
                case 1: typeMap.merge("" + survey[i].charAt(0), 3, Integer::sum); break;
                case 2: typeMap.merge("" + survey[i].charAt(0), 2, Integer::sum); break;
                case 3: typeMap.merge("" + survey[i].charAt(0), 1, Integer::sum); break;
                case 4: break;
                case 5: typeMap.merge("" + survey[i].charAt(1), 1, Integer::sum); break;
                case 6: typeMap.merge("" + survey[i].charAt(1), 2, Integer::sum); break;
                case 7: typeMap.merge("" + survey[i].charAt(1), 3, Integer::sum); break;
            }
        }
        
        // get type
        String ans = "";
        ans += (typeMap.get("R") < typeMap.get("T")) ? "T" : "R";
        ans += (typeMap.get("C") < typeMap.get("F")) ? "F" : "C";
        ans += (typeMap.get("J") < typeMap.get("M")) ? "M" : "J";
        ans += (typeMap.get("A") < typeMap.get("N")) ? "N" : "A";
        
        return ans;
    }
}