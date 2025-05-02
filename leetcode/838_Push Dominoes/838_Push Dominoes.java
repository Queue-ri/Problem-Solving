class Solution {
    int[] rdist;
    int[] ldist;
    int n;

    public String pushDominoes(String dominoes) {
        n = dominoes.length();
        char[] dArr = dominoes.toCharArray();
        rdist = new int[n];
        ldist = new int[n];
        
        int force = 0;
        for (int i = 0; i < n; ++i) {
            if (dArr[i] == 'R') {
                force = 1;
                rdist[i] = force++;
            }
            else if (dArr[i] == 'L') {
                rdist[i] = 0;
                force = 0;
            }
            else {
                if (force > 0) rdist[i] = force++;
                else rdist[i] = 0;
            }
        }

        force = 0;
        for (int i = n-1; i > -1; --i) {
            if (dArr[i] == 'L') {
                force = 1;
                ldist[i] = force++;
            }
            else if (dArr[i] == 'R') {
                ldist[i] = 0;
                force = 0;
            }
            else {
                if (force > 0) ldist[i] = force++;
                else ldist[i] = 0;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (dArr[i] == '.') {
                if (ldist[i] < rdist[i]) dArr[i] = ldist[i] > 0 ? 'L' : 'R';
                else if (ldist[i] > rdist[i]) dArr[i] = rdist[i] > 0 ? 'R' : 'L';
            }
        }

        return String.valueOf(dArr);
    }
}