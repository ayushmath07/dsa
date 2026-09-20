class Solution {
    public boolean containsDuplicate(int[] nums) {
        // [1,2,3,1] true --> O(n^2)
        //  i     j
        // [1,1,2,3] -> O(nlogn) | sc O(1)
        // [1,2,3,1] -> {1,2,3} -> true -> O(n) | sc O(n) best
        Set<Integer> set  = new HashSet<>();
        for(int i:nums){
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}