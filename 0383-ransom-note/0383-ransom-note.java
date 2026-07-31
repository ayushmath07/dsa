class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransom = new int[26];
        int[] have = new int[26];
        for(int i =0;i<ransomNote.length();i++){
            ransom[ransomNote.charAt(i)-'a']++;
        }
        for(int i =0;i<magazine.length();i++){
            have[magazine.charAt(i)-'a']++;
        }
        for(int i =0;i<26;i++){
            if(ransom[i]>have[i]) return false;
        }
        return true;
    }
}