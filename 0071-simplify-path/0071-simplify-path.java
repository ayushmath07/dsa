class Solution {
    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();

        String[] arr = path.split("/");

        for(String s : arr){

            if(s.equals("") || s.equals(".")){
                continue;
            }

            if(s.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(s);
            }
        }

        if(st.isEmpty())
            return "/";

        StringBuilder ans = new StringBuilder();

        for(String dir : st){
            ans.append("/").append(dir);
        }

        return ans.toString();
    }
}