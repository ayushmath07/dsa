class Solution {
    class Pair{
        char ch;
        int cnt;

        Pair(char ch,int cnt){
            this.ch = ch;
            this.cnt = cnt;
    }}
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stk.isEmpty()){
                stk.push(new Pair(c,1));
                continue;
            }
            else if(stk.peek().ch != c){
                stk.push(new Pair(c,1));
                continue;
            }
            else if(stk.peek().ch == c && stk.peek().cnt < k-1){
                Pair cur = new Pair(c,stk.peek().cnt+1);
                stk.pop();
                stk.push(cur);
                continue;
            }
            stk.pop();

        }
        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty()){
            Pair ele = stk.pop();
            for(int i=0;i<ele.cnt;i++){
                res.append(ele.ch);
            }
        }
        return res.reverse().toString();
    }
}