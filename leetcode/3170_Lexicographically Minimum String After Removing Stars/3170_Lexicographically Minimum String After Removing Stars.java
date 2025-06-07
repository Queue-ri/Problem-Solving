class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // asc
            }
            else {
                return b[1] - a[1]; // desc
            }
        });

        char[] sArr = s.toCharArray();
        boolean[] removed = new boolean[sArr.length];
        for (int i = 0; i < sArr.length; ++i) {
            char ch = sArr[i];
            if (ch != '*')
                pq.add(new int[]{ch, i});
            else {
                int[] e = pq.poll();
                removed[i] = true; // remove star
                removed[e[1]] = true; // remove target letter
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; ++i) {
            if (!removed[i]) sb.append(sArr[i]);
        }

        return sb.toString();
    }
}