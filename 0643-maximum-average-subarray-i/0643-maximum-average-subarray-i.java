class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // ~0.00001
        // 1,12,-5,-6,50,3 12,-5,-6,50 = 51 /4 = 12.75
        // 51 /4
        // [1,12,-5,-6,50,3] 4 max = sum sum/k as k is constant
    // O(n)
    double sum = 0; //51
     //2
    // k < n
    for(int i =0;i<k;i++){
        sum+= nums[i];
    }
    
    // [1,-12,-5,-6,50,3] 1 
    double res = sum; //2
    int right=k-1,left = 0;
    while(right<nums.length){
        // System.out.println(res);
        res = Math.max(res,sum);
        
        right++;
        if(right>= nums.length) break;
        sum+=nums[right];//52
        sum-=nums[left]; //51
        left++;
        
    }
    return res/k; //0.00001 10**-5
    }
}