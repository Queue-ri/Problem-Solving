class Solution {
    int[] nxt;
    
    public void union(int a, int b) {
        int r1 = find(a);
        int r2 = find(b);
        
        if (r1 < r2) nxt[r2] = r1;
        else if (r1 > r2) nxt[r1] = r2;
        else return;
    }

    public int find(int n) {
        if (n == nxt[n]) return n; // is root
        int root = find(nxt[n]);
        nxt[n] = root;
        return root;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        nxt = new int[26];
        for (int i = 0; i < 26; ++i) nxt[i] = i;

        // guarantee lex smallest by root value comparison
        // ex. if r1 < r2 then nxt[r2] = r1

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for (int i = 0; i < s1.length(); ++i) {
            int a = s1Arr[i]-'a';
            int b = s2Arr[i]-'a';
            if (find(a) != find(b)) union(a, b);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            sb.append((char)(find(ch-'a')+'a'));
        }

        return sb.toString();
    }
}