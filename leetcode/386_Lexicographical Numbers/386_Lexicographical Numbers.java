class Solution {
    int n;
    List<Integer> ans;

    public void rcs(int i) {
        ans.add(i);
        for (int j = 0; j < 10; ++j) {
            int k = i*10 + j;
            if (k <= n) rcs(k);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        ans = new ArrayList<>();
        for (int i = 1; i < 10; ++i)
            if (i <= n) rcs(i);
        return ans;
    }
}