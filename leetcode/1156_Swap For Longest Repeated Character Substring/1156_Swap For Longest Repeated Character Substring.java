class Solution {
    static {
        for (int i=0; i < 100; ++i) maxRepOpt1("");
    }

    public static int maxRepOpt1(String text) {
        Map<Character, Integer> chMap = new HashMap<>(); // char counters
        char[] textArr = text.toCharArray();

        for (char ch : textArr) {
            chMap.merge(ch, 1, Integer::sum);
        }

        // calc 1-ignorance length
        int mxlen = 1; // if text.length == 1 then mxlen is 1
        int i = 0;
        int j = 1;
        while (i < textArr.length) {
            char targetCh = textArr[i];
            int len = 1;
            boolean skipped = false; // 1-ignored?
            j = i+1;
            int breakPoint = j;
            while (j < textArr.length) {
                if (textArr[j] == targetCh) ++j; // same
                else { // not same
                    if (!skipped) {
                        breakPoint = j;
                        skipped = true;
                        ++j;
                    }
                    else break;
                }
            }
            if (!skipped) breakPoint = j;

            // if not skipped then force extend (corner case)
            int extended = (skipped ? j-i : j-i+1);

            // if no spare character then -1
            int cand = (chMap.get(targetCh) < extended) ? extended-1 : extended;
            //System.out.println(textArr[i] + " " + chMap.get(targetCh) + " " + cand);

            mxlen = Math.max(mxlen, cand);
            i = breakPoint;
        }
        
        return mxlen;
    }
}