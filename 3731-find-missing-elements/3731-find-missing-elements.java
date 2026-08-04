class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        int num = nums[0];
        int i=1;
        while(i<nums.length){
            if(num+1 != nums[i]){
                l.add(num+1);
            }
            else i++;
            num++;
        }
        return l;
    }
}