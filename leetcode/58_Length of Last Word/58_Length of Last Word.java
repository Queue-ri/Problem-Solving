class Solution {
    public static int lengthOfLastWord(String s) {
        String[] segments = s.split(" ");
        return segments[segments.length-1].length();
    }
}