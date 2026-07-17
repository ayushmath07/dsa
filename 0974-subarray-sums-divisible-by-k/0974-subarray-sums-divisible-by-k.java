class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, res=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            sum+=i;
            int rem = sum%k;
            if(rem<=-1) rem+=k;
            if(map.containsKey(rem)) res+=map.get(rem);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return res;
    }
}