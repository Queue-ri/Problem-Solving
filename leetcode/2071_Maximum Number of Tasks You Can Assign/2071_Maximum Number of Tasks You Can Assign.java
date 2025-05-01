class Solution {
    int[] tasks;
    int[] workers;
    int pills;
    int strength;

    // check k tasks assignment availability
    public boolean avail(int k) {
        int tdx = 0; // task index
        int pCnt = pills; // number of pills
        Deque<Integer> q = new ArrayDeque<>(); // task queue

        // workers: low(start w/ best attempt) -> high | tasks: lowest -> high
        for (int wdx = workers.length-k; wdx < workers.length; ++wdx) {
            // q: all cadidate tasks that wdx can handle including pill strength
            while (tdx < k && tasks[tdx] <= workers[wdx]+strength) {
                q.add(tasks[tdx++]);
            }

            if (q.isEmpty()) return false;
            
            if (q.peekFirst() <= workers[wdx]) q.pollFirst();
            else if (pCnt == 0) return false; // need pill but none left
            else {
                --pCnt;
                q.pollLast(); // use pill & task hardest
            }
        }

        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        this.pills = pills;
        this.strength = strength;

        // sort for bsearch
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;

        // bsearch
        int l = 0;
        int r = Math.min(tasks.length, workers.length);
        while (l < r) {
            int m = (l+r+1) / 2;
            if (avail(m)) l = m;
            else r = m - 1;
        }

        return l;
    }
}