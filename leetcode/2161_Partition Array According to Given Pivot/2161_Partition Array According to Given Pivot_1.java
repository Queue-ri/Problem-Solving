class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> preList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        for (int i=0; i<nums.length; ++i) {
            int n = nums[i];

            if (n < pivot) {
                preList.add(n);
            }
            else if (nums[i] == pivot) {
                midList.add(n);
            }
            else {
                postList.add(n);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        Stream.of(preList, midList, postList).forEach(ansList::addAll);
        
        return ansList.stream().mapToInt(i->i).toArray();
    }
}