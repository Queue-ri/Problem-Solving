import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Boolean> cache = new LinkedHashMap<>(cacheSize+1, 1.0f, true);
        
        // simulate
        if (cacheSize == 0) return cities.length * 5; // corner case
        
        int ans = 0;
        for (int i = 0; i < cities.length; ++i) {
            String keyword = cities[i].toLowerCase();
            if (cache.containsKey(keyword)) { // cache hit
                cache.get(keyword); // trigger accessOrder
                ans += 1;
            }
            else { // cache miss
                if (cache.size() >= cacheSize) { // cache is full -> swap
                    // NoSuchElementException 조심
                    // corner case 처리 안하면 NSEE 발생
                    cache.remove(cache.keySet().iterator().next());
                }
                cache.put(keyword, true);
                ans += 5;
            }
        }
        
        return ans;
    }
}