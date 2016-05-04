package qiang.dfs;

import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveInvalidParentheses301 dd = new RemoveInvalidParentheses301();
		System.out.println(dd.removeInvalidParentheses("()(("));
	}
    public List<String> removeInvalidParentheses(String s) {
    	List<String> ans = new LinkedList<>();
    	dfs(s,0,0,ans,new char[]{'(',')'});
    	return ans;
    }
    /**
     * i 是当前处理到的位置，j是上一次删除的括号的位置
     * @param curS
     * @param i
     * @param j
     * @param ans
     */
    void dfs(String curS,int i,int j,List<String> ans, char[]par){
    	
    	int sta=0;
    	int k = i;
    	for(;k<curS.length();k++){
    		if(curS.charAt(k)==par[0])sta++;
    		else if(curS.charAt(k)==par[1]) sta--;
    		if(sta < 0) break;
    	}
    	if(sta <0){
    		
    		for(int d = j;d<k+1;d++){
    			if(curS.charAt(d) == par[1] && ( d==j || curS.charAt(d-1)!=par[1] )){
    				String can = curS.substring(0,d)+curS.substring(d+1);
    				dfs(can,k,d,ans,par);
    			}
    		}
    		return ;
    	}
        // 大于等于0的时候
        String re = new StringBuilder(curS).reverse().toString();
        if(par[0] == '('){
            if(sta ==0 ){
                ans.add(curS);
            }else
            dfs(re,0,0,ans,new char[]{')','('});
        }else{
            ans.add(re);
        }
    	
    }
}
