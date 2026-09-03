class Solution {
    public boolean isPalindrome(String s) {
        // preprossesing text O(n)
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;right--;
        }
        return true;
       // start end -> middle check if same or not O(n)
       // reversing and comparing O(n) + O(n) -> O(2*n) +s O(n)
    }
}