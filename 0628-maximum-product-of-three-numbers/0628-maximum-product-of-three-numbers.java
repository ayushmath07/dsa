class Solution {
    public int maximumProduct(int[] nums) {
        int first=Integer.MIN_VALUE;
        int sec = first;
        int third = sec;
        if(nums.length<3) return 0;
        for(int i:nums){
            if(i>first){
                third = sec;
                sec =  first;
                first = i;
            }
            else if(i>sec){
                third = sec;
                sec = i;
            }
            else if(i>third){
                third = i;
            }
        }
        int nfirst=Integer.MAX_VALUE;
        int nsec = nfirst;
        for(int i:nums){
            if(i<nfirst){
                nsec =  nfirst;
                nfirst = i;
            }
            else if(i<nsec){
                nsec = i;
            }
        }
        return Math.max(first*sec*third,nfirst*nsec*first);
    }
}