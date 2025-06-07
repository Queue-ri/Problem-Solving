class Solution {
    public String robotWithString(String s) {
        // 첫 글자를 미리 t로 init
        final int n = s.length();
        int[] remained = new int[26];
        char[] sArr = s.toCharArray();
        for (char ch : sArr) ++remained[ch-'a'];

        char[] t = new char[n];
        t[0] = sArr[0];
        --remained[sArr[0]-'a'];

        int i = 1;
        int j = 1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            if (j < 1) {
                t[j++] = sArr[i];
                --remained[sArr[i++]-'a'];
            }
            else if (i == n) {
                //System.out.println("i==n: " + t[j-1]);
                sb.append(t[--j]);
            }
            else if (t[j-1] <= sArr[i]) { // 작거나 같음 -> 출력? 보류?
                boolean smallest = true;
                for (int k = t[j-1]-'a'-1; -1 < k; --k) {
                    if (0 < remained[k]) {
                        smallest = false; // 더 작은 값 발견
                        break;
                    }
                }
                //System.out.println("smallest: " + smallest + " " + t[j-1] + " " + sArr[i]);
                if (smallest)
                    sb.append(t[--j]); // 출력: 지금꺼가 최선
                else {
                    t[j++] = sArr[i]; // 보류: 미래에 더 작은 값 존재
                    --remained[sArr[i++]-'a'];
                }
            }
            else {
                t[j++] = sArr[i]; // 보류: 출력 후보 t[j]보다 sArr[i]가 더 작음
                --remained[sArr[i++]-'a'];
            }
        }

        return sb.toString();
    }
}