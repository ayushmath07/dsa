class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[4,3,2,7,8,2,3,1] sorting O(n) somehow
        //cyclic O(n) [1-n].
        //extra 
        // 4 -> i = nums[i]-1 //duplicate -> duplicate O(n)
        //1,1,2,1,3,2,7,8 -> O(n) x 
        //5 6
        //1,1 -> 2
        //O(2n) -> O(1)
        //[3,2,2,4,8,2,7,1]
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int n= nums.length;
        //[4,3,2,7,8,2,3,1] -> 4,3,2,7,8,1 set.contains 1 to n
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int num =1;num<=n;num++){
            if(!set.contains(num)){
                res.add(num);
            }
        }
        return res;
    }
}