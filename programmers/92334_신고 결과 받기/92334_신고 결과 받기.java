import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reporterMap = new HashMap<>();
        Map<String, Integer> mailCntMap = new HashMap<>();
        
        // init
        for (String id : id_list) {
            reporterMap.put(id, new HashSet<>());
            mailCntMap.put(id, 0);
        }
        
        // collect report
        for (String r : report) {
            String[] rArr = r.split(" ");
            String from = rArr[0];
            String to = rArr[1];
            Set<String> fromSet = reporterMap.get(to); // shallow copy
            if (fromSet.contains(from)) continue; // 'from' should be unique
            fromSet.add(from);
        }
        
        // send mail
        for (Map.Entry<String, Set<String>> e : reporterMap.entrySet()) {
            Set<String> fromSet = e.getValue();
            int reportCnt = fromSet.size();
            if (reportCnt < k) continue;
            for (String from : fromSet) {
                mailCntMap.merge(from, 1, Integer::sum);
            }
        }
        
        // count
        int[] ans = new int[id_list.length];
        for (int i = 0; i < id_list.length; ++i) {
            ans[i] = mailCntMap.get(id_list[i]);
        }
        return ans;
    }
}