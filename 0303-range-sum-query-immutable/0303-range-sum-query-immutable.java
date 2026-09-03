class NumArray {
    int[] prefixArr;
    int n;
    // 0,  1, 2, 3,  4, 5
    // -2, 0, 3, -5, 2, -1
    // -3, 
    //1, -4
    //
    // sum =    
    // 0, 2
    // 0, 5 
    // m ranges n* m , n.
    

    public NumArray(int[] nums) {
        n = nums.length;
        prefixArr = new int[n];
        prefixArr[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixArr[i] = prefixArr[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefixArr[right];
        return prefixArr[right] - (prefixArr[ left - 1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */