class Solution {
    public int maxNumberOfBalloons(String text) {
        int arr[] = {1,1,2,2,1};
        int real[] = {0,0,0,0,0};
        int res =Integer.MAX_VALUE;
        for(int i = 0;i<text.length();i++){
            if(text.charAt(i) == 'b'){
                real[0]++;
            }
            else if(text.charAt(i) == 'a'){
                real[1]++;
            }
            else if(text.charAt(i) == 'l'){
                real[2]++;
            }
            else if(text.charAt(i) == 'o'){
                real[3]++;
            }
            else if(text.charAt(i) == 'n'){
                real[4]++;
            }
        }
        for(int i = 0;i<5;i++){
            res = Math.min(res,real[i]/arr[i]);
        }
        return res;
    }
}