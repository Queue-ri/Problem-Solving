class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ansList = new ArrayList<>();
ifor:   for (int i = 0; i < words.length; ++i)
            for (char ch : words[i].toCharArray())
                if (ch == x) {
                    ansList.add(i);
                    continue ifor;
                }
        
        return ansList;
    }
}