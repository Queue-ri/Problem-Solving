class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else {
                if (st.isEmpty()) return false;
                char pair = st.pop();
                if (ch == ')') {if (pair != '(') return false;}
                else if (ch == '}') {if (pair != '{') return false;}
                else {if (pair != '[') return false;}
            }
        }

        return st.isEmpty();
    }
}