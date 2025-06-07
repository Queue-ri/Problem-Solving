import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {  
        int cnt = 0;
        int day = 0;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < progresses.length; ++i) {
            int p = progresses[i];
            int s = speeds[i];
            
            if (p + s*day > 99) ++cnt; // 1. can release
            else { // 2. can't release
                // save total releases (skip if 0)
                if (0 < cnt) ansList.add(cnt);
                cnt = 0;
                
                // calc required days to release
                day = (100-p) / s;
                if ((100-p) % s != 0) day += 1;
                
                ++cnt;
            }
        }
        ansList.add(cnt);
        
        return ansList.stream().mapToInt(i->i).toArray();
    }
}