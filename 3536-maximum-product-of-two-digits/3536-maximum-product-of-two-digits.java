class Solution {
    public int maxProduct(int n) {
        int num1=0,num2=0;
        while(n>0){
            int ld = n%10;
            if(num1<num2){
                num1= Math.max(ld,num1);
            }
            else{
                num2 =Math.max(ld,num2);
            }
            n/=10;
        }
        return num1*num2;
    }
}