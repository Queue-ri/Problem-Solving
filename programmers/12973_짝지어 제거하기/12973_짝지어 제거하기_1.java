class Solution
{
    public int solution(String s)
    {
        char[] st = new char[s.length()];
        int i = 0; // stack pointer
        
        for (char ch : s.toCharArray()) {
            if (i < 1 || st[i-1] != ch) st[i++] = ch;
            else --i;
        }
        
        return i == 0 ? 1 : 0;
    }
}