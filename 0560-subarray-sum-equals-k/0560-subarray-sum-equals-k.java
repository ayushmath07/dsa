class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            sum+=i;
            int x = sum-k;
            if(map.containsKey(x)) res+= map.get(x);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}