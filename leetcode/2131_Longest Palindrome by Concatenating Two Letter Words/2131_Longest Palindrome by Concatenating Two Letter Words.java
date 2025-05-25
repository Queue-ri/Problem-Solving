class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> diffHash = new HashMap<>();
        Map<String, Integer> sameHash = new HashMap<>();
        int ans = 0;

        for (String w : words) {
            if (w.charAt(0) == w.charAt(1)) {
                sameHash.merge(w, 1, Integer::sum);
            }
            else {
                String rw = new StringBuilder(w).reverse().toString();
                int v = diffHash.getOrDefault(rw, 0);
                if (v == 0) {
                    diffHash.merge(w, 1, Integer::sum);
                }
                else {
                    ans += 4;
                    diffHash.merge(rw, -1, Integer::sum);
                }
            }
        }

        boolean hasMid = false;
        for (int v : sameHash.values()) {
            if (0 < v) {
                ans += v >> 1 << 2;
                if ((v & 1) == 1) hasMid = true;
            }
        }

        return ans + (hasMid ? 2 : 0);
    }
}