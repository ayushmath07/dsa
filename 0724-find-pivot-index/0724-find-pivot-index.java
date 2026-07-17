class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0,right = 0;
        for(int i: nums){
            right+=i;
        }
        int idx =0;
        for(int i:nums){
            right-=i;
            if(left==right) return idx;
            left+=i;
            idx++;
        }
        return -1;
    }}