package qiang.dfs;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class LetterCombinationsofaPhoneNumber17 {

	public static void main(String[] args) {
		
		LetterCombinationsofaPhoneNumber17 con = new LetterCombinationsofaPhoneNumber17();
		List<String> ans  = con.letterCombinations("234");
		PrintUtil.printList(ans);
	}
	
	 public List<String> letterCombinations(String digits) {
	     
		 List<String> ans = new LinkedList<>();
		 if(digits == null || digits.length() == 0)return ans;
		 String [] allNums ={"","" ,"abc" ,"def" ,"ghi" ,"jkl" ,"mno" ,"pqrs" ,"tuv" ,"wxyz" };    
		 this.dfs("", digits, 0, allNums, ans);
		 return ans;
	 }
	 
	 /**
	  * 
	  * @param oneAns  
	  * @param digits
	  * @param index  当前处理到digits的哪个字符
	  * @param allNums
	  * @param ans
	  */
	 void dfs(String oneAns,String digits,int index,String []allNums,List<String> ans){
		 
		 if(index == digits.length()){
			 ans.add(oneAns);
			 return;
		 }
		 char cur = digits.charAt(index);
		 String chars = allNums[cur-'0'];
		 for(int i = 0 ;i < chars.length();i++){
			 this.dfs(oneAns+chars.charAt(i), digits, index+1, allNums, ans);
		 }
	 }
}
