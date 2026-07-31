class Solution {
    public int longestPalindrome(String s) {
        int[] arr= new int[256];
        for(int i =0;i<s.length();i++){
            arr[s.charAt(i)]++;
        }
        int res = 0;
        boolean hasodd = false;
        for(int i = 0;i<256;i++){
            if(arr[i]%2==0) res += arr[i];
            else{
                res+= arr[i]-1;
                hasodd=true;
            }
        }
        if(hasodd) res++;
        return res;

    }
}