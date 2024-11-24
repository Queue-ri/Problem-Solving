import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> sumList = new ArrayList<>();
        
        for (int i = 0; i < numbers.length-1; ++i) {
            for (int j = i+1; j < numbers.length; ++j) {
                sumList.add(numbers[i] + numbers[j]);
            }
        }
    
        return sumList.stream().distinct().sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}