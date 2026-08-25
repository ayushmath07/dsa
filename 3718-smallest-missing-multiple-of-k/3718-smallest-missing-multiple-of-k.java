class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        //2 3 4 6 8
        int curr_k = k;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==curr_k){
                curr_k+=k;
            }
            else if(nums[i]>curr_k)break;

            
        }
        return curr_k;
    }
}