class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // [16,1,0,9,100]
        // [0, 1, 9, 16]
        
        // [4]
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        
        int[] res = new int[n];
        int i = 0;
        int findPivotIdx = 0; // 2
        
        while(findPivotIdx < n - 1) {
            if(nums[findPivotIdx] < nums[findPivotIdx + 1]) {
                break;
            }
            findPivotIdx++;
        }
        
        int right = findPivotIdx;
        int left = findPivotIdx - 1;
        
        while(left >= 0 && right < n) {
            if(nums[left] > nums[right]) {
                res[i++] = nums[right++];
            }else {
                res[i++] = nums[left--];
            }
        }
        
                
        while(right < n) res[i++] = nums[right++];
        while(left >= 0) res[i++] = nums[left--];
        
        return res;
    }
}