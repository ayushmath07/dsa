class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = 1,even = 2;
        int oddsum=0,evensum=0;
        while(n-->0){
            oddsum+=odd;
            evensum+=even;
            odd+=2;
            even+=2;
        }
        while(evensum!=0){
            int rem = oddsum%evensum;
            oddsum = evensum;
            evensum = rem;
        }
        return oddsum;
    }
}