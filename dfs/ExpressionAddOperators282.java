package qiang.dfs;

import java.util.LinkedList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class ExpressionAddOperators282 {

	public static void main(String[] args) {
		List<String> ans = new ExpressionAddOperators282().addOperators("105", 5);
		PrintUtil.printList(ans);
	}
	
	 public List<String> addOperators(String num, int target) {
		 	List<String> ans = new LinkedList<>();
	        dfs(ans, new LinkedList<String>(), num, 0, 0, target);
	        return ans;
	 }
	 
	 void dfs( List<String> ans,LinkedList<String> oneAns,String num,int curIndex,long lastNum,long left){
		 
		 if(left == 0 && curIndex == num.length()){
			 StringBuilder sb = new StringBuilder();
			 String a;
			 for(int i=0;i<oneAns.size();i++){
				 a = oneAns.get(i);
				 if(i == 0 & a.equals("+"))continue;
				 sb.append(a);
			 }
			 ans.add(sb.toString());
			 return;
		 }
		 if(curIndex > num.length()-1)return;
		 //if(left < 0) return;
		 
		 // 深搜
		 String tempN;
		 long tempNum;
		 for(int i = curIndex; i < num.length();i++){
			 tempN = num.substring(curIndex,i+1);
			 if(i-curIndex > 0 && tempN.charAt(0)=='0')continue;
			 tempNum = Long.parseLong(tempN);
			 
			 for(int j = 0;j<3;j++){
				 switch(j){
				
				 	case 0:  // + 在当前tempNum前面添加的符号
				 		//lastNum = tempNum;
				 		oneAns.addLast("+");
				 		oneAns.addLast(tempN);
				 		dfs(ans, oneAns, num, i+1, tempNum, left-tempNum);
				 		oneAns.removeLast();
				 		oneAns.removeLast();
					 break;
				 	 case 1: // -
				 		 if(curIndex == 0 )continue;
				 		oneAns.addLast("-");
				 		oneAns.addLast(tempN);
				 		dfs(ans, oneAns, num, i+1, -tempNum, left+tempNum);
				 		oneAns.removeLast();
				 		oneAns.removeLast();
						break;
				 	 case 2: // *
				 		 if(curIndex != 0) {
				 			 oneAns.addLast("*");
				 			 oneAns.addLast(tempN);
				 			 dfs(ans, oneAns, num, i+1, lastNum*tempNum, (left+lastNum)-lastNum*tempNum);
				 			 oneAns.removeLast();
				 			 oneAns.removeLast();
				 			 break;
						 }
				 }
				 
			 }
		 }
		 
	 }
}
