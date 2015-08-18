package qiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

	/**
	 * 
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis(int n) {
       List<String> ans = new ArrayList<String>();
       generateRecur(n, n, "", ans);
       return ans;
    	
    }
    /**
     * 
     * @param left  剩余的左括号数量
     * @param right 剩余的右括号数量
     * @param oneAns 一个解
     * @param ans    最终的解
     */
    private void generateRecur(int left,int right,String oneAns,List<String> ans){
    	if(left == 0 && right== 0){
    		System.out.println(oneAns);
    		ans.add(oneAns);
    		return ;
    	}
    	if(left >0){
    		generateRecur(left-1, right, oneAns+"(", ans);
    		
    	}
    	if(right >0 && left < right){
    		generateRecur(left, right-1, oneAns+")", ans);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses22 gp = new GenerateParentheses22();
		gp.generateParenthesis(6);
	}

}
