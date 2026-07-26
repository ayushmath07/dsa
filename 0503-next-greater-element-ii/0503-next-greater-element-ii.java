class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            int idx = i%n;
            while(!stk.isEmpty() && stk.peek()<= nums[idx]){
                stk.pop();
            }
            if(stk.isEmpty()){
                res[idx] = -1;
            }
            else{
                res[idx] = stk.peek();
            }
            stk.push(nums[idx]);
        }
        return res;
    }
}