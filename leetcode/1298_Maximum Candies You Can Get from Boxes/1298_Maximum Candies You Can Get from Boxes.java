class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        boolean[] visited = new boolean[status.length];
        boolean[] haveKey = new boolean[status.length];

        // init
        Deque<Integer> q = new ArrayDeque<>();
        for (int i : initialBoxes) {
            q.add(i);
            visited[i] = true;
            for (int j : keys[i]) haveKey[j] = true;
        }
        
        // break condition: found no key & box == hopeless
        boolean hope = true;
        int ans = 0;
        while (hope) {
            int sz = q.size();
            hope = false;
            while (sz-- > 0) {
                int i = q.poll();
                if (status[i] == 1 || (status[i] == 0 && haveKey[i])) { // 1. opened or can open
                    for (int k : keys[i]) {
                        if (haveKey[k]) continue; // useless key
                        haveKey[k] = true; // get keys
                        hope = true;
                    }
                    for (int b : containedBoxes[i]) {
                        if (visited[b]) continue;
                        q.add(b); // get boxes
                        visited[b] = true;
                        hope = true;
                    }
                    ans += candies[i];
                }
                else { // 2. closed or can't open
                    q.add(i);
                }
            }
        }

        return ans;
    }
}