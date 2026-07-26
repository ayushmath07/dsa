class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(!stk.isEmpty() && stk.peek()==c){
                stk.pop();
                i++;
                continue;
            }
            stk.push(c);
            i++;
        }
        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty()){
            res.append(stk.pop());
        }
        return res.reverse().toString();
    }
}