public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0){
            return digits;
        }
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]+=1;
                return digits;
            }
            carry=(digits[i]+1)/10;
            digits[i]=0;
        }
        if(carry==1){
            int[]result=new int[digits.length+1];
            result[0]=1;
            return result;
        }
        return digits;
    }
}