public class EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        int []stack=new int[tokens.length];
        int top=-1;
        int result=0;
        if(tokens.length==1 && (tokens[0]!="*"||tokens[0]!="/"||tokens[0]!="+"||tokens[0]!="-")){
            return convert(tokens[0]);
        }
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].charAt(0)-'0'>=0 && tokens[i].charAt(0)-'0'<=9 || (tokens[i].charAt(0)=='-' && tokens[i].length()>=2)){
                ++top;
                stack[top]=convert(tokens[i]);
            }else if(top>=1){
                char cal=tokens[i].charAt(0);
                int second=stack[top];
                --top;
                int first=stack[top];
                --top;
                result=0;
                result+=calculate(first,second,cal);
                ++top;
                stack[top]=result;
            }
        }
        return result;
    }
    public int calculate(int first, int second,char cal){
        int res=0;
        if(cal=='+'){
            res+=first+second;
        }
        if(cal=='-'){
            res+=first-second;
        }
        if(cal=='*'){
            res+=first*second;
        }
        if(cal=='/' && second!=0){
            res+=first/second;
        }
        return res;
    }
    
    public int convert(String s){
        int result=0;
        int i=0;
        boolean negative=false;
        if(s.charAt(0)=='-'){
            i++;
            negative=true;
        }
        while(i<s.length()){
            result=result*10+s.charAt(i)-'0';
            i++;
        }
        return negative?result*(-1):result;
    }
}