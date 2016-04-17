public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        char[] stack=new char[s.length()];
        int top=-1;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='[' || cur=='{' || cur=='('){
                ++top;
                stack[top]=cur;
            }
            else if(top<0) return false;
            else if((cur==']'&&stack[top]!='[') || 
                (cur=='}'&&stack[top]!='{') || (cur==')'&&stack[top]!='(')){
                return false;
            }
              else{     
                    --top;
                }
        }
        return top==-1;
    }
}