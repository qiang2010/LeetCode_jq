package qiang.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII267 {
	 
	public static void main(String[] args) {
		PalindromePermutationII267 pa = new PalindromePermutationII267();
		System.out.println(pa.generatePalindromes("aabbccccc"));
	}
	String oddc="";
	public List<String> generatePalindromes(String s) {
		List<String> ans = new LinkedList<>();
		if(s == null || s.length() ==0) return ans;
		Map<Character,Integer> count = new HashMap<>();
		for(char a:s.toCharArray()){
			if(count.containsKey(a)){
				count.put(a,count.get(a)+1);
			}else count.put(a, 1);
		}
		int odd = 0;
		int palSize = 0;
		for(char a:count.keySet()){
			int c = count.get(a);
			if( (c&1)==1 ) {
				odd++;
				oddc = a+"";
			}
			if(odd>1) return ans;
			count.put(a, c/2);
			palSize +=c/2;
		}
		dfs(ans, count, new StringBuilder(), 0, palSize);
		return ans;
	 }
	/**
	 * 
	 * @param ans 
	 * @param count  每个字符的统计
	 * @param tempAns
	 * @param curP  当前要用第几个字符了
	 * @param palSize  最终的字符有几个
	 */
	void dfs(List<String> ans,Map<Character,Integer> count,StringBuilder tempAns,int curP,int palSize){
		if(curP == palSize){ // 得到一个结果
			String a = tempAns.toString() +oddc+tempAns.reverse().toString();
			ans.add(a);
			return;
		}
		// dfs
		for(char a: count.keySet()){
			int cc = count.get(a);
			if(cc == 0) continue;
			tempAns.append(a);
			count.put(a, cc-1);
			dfs(ans, count, tempAns, curP+1, palSize);
			count.put(a, cc);
			tempAns.deleteCharAt(tempAns.length()-1);
		}
	}
}
