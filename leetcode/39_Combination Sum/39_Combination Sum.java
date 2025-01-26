class Solution {
    int[] cand;
    int t;
    List<List<Integer>> combList;
    
    public void createComb(int i, int n, int total, List<Integer> candList) {
        //System.out.println(n + " " + total + " " + candList.toString());
        // base case
        if (n == 0) {
            if (total == t) {
                //System.out.println("*** " + candList.toString());
                combList.add(candList);
            }
            
            return;
        }
        if (total > t) return;

        // iterate including self
        for (int j = i; j < cand.length; ++j) {
            List<Integer> newCandList = new ArrayList<>();
            newCandList.addAll(candList);
            newCandList.add(cand[j]);
            createComb(j, n-1, total+cand[j], newCandList);
        }

        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        cand = candidates;
        t = target;
        combList = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();

        // n: number of picked elements in a single combination (=unit)
        for (int n = 1; n < target; ++n) {
            for (int i = 0; i < candidates.length; ++i) {
                combList = new ArrayList<>(); // reset
                createComb(i, n-1, cand[i], new ArrayList<>(Arrays.asList(cand[i])));
                ansList.addAll(combList);
            }
        }
        
        return ansList;
    }
}