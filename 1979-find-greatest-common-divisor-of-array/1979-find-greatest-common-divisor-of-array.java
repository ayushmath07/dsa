class Solution {
    public int findGCD(int[] nums) {
        int a = 1001,b=-1;
        for(int i:nums){
            a = Math.min(i,a);
            b = Math.max(i,b);
        }
        while(a!=0){
            int temp = b%a;
            b = a;
            a = temp;
        }
        return b;
    }
}