import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // System.out.println(System.getProperty("java.version"));
        int[] ans = new int[commands.length];
        List<Integer> data = Arrays.stream(array).boxed().collect(Collectors.toList());
        
        for (int i = 0; i < commands.length; ++i) {
            List<Integer> sub = data.subList(commands[i][0]-1, commands[i][1]);
            sub = sub.stream().sorted().collect(Collectors.toList());
            ans[i] = sub.get(commands[i][2]-1);
        }
        
        return ans;
    }
}