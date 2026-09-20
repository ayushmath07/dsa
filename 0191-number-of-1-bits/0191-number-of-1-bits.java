class Solution {
    public int hammingWeight(int n) {
        
        // set = 3          n = n & n-1 0001 set++
        // n -> 0
        // 1011 -> 11
        // 1010 &
        // 1010 -> 10
        // 1001 & 
        // 1000 -> 8
        // 0110 &
        // 0000
        
        int set = 0;
        
        while(n > 0) {
            set++;
            
            n = n & (n - 1);
        }
        
        return set;
    }
}