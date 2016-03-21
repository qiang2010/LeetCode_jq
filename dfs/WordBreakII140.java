package qiang.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII140 {
	
	public static void main(String[] args) {
		
		Set<String> wordDict= new HashSet<String>();
		wordDict.add("a");
//		wordDict.add("aa");
//		wordDict.add("aaaa");
//		wordDict.add("aaa");
//		wordDict.add("aaaaa");
		List<String> ans = new WordBreakII140().wordBreak("a", wordDict);
		System.out.println(ans);
	}
	
	// 记录词典中的单词最大值最小值
		public List<String> wordBreak(String s, Set<String> wordDict) {
			List<String> ans = new LinkedList<String>();
			if(s == null ||s.length()==0) return ans;
			int wl;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(String w:wordDict){
				wl = w.length();
				min = min < wl?min:wl;
				max = max > wl? max:wl;
			}
			Map<Integer,List<String>> tempAns = new HashMap<>();
			List<String> zero = new ArrayList<String>(),tempList;
			zero.add("");
			boolean dp[] = new boolean[s.length()+1];
			dp[0] = true;
			for(int i =0; i < s.length()+1;i++){
				if(!dp[i])continue;
				for(int len = min; len<max+1 && i+len<s.length()+1;len++){
					int end = i+len;
					String temp = s.substring(i,end);
					if(wordDict.contains(temp)){
						dp[end] = true;
					}
				}
			}
			if(!dp[s.length()]){
				return ans;
			}
//			System.out.println(99);
			String blank = "";
			for(int i =0; i < s.length()+1;i++){
			    if(i!=0)blank=" ";
				if(!dp[i])continue;
				for(int len = min; len<max+1 && i+len<s.length()+1;len++){
					int end = i+len;
					String temp = s.substring(i,end);
					if(wordDict.contains(temp)){
						dp[end] = true;
						if(tempAns.containsKey(i)){
							zero = tempAns.get(i);
						}
						if(tempAns.containsKey(end)){
							tempList = tempAns.get(end);
						}else{
							tempList = new LinkedList<>();
							tempAns.put(end, tempList);
						}
						for(String last:zero){
							tempList.add(last+blank+temp);
						}
					}
				}
			}
			return tempAns.get(s.length());
		
		}
	
	
	// 记录词典中的单词最大值最小值
	int min;
	int max;
	public List<String> wordBreak2(String s, Set<String> wordDict) {
	        
		List<String> ans = new LinkedList<String>();
		if(s == null ||s.length()==0) return ans;
		int wl;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for(String w:wordDict){
			wl = w.length();
			if(wl<min){
				min = wl;
			}else{
				if(wl > max)max = wl;
			}
		}
		dfs(ans, new LinkedList<String>(), s, 0, wordDict);
		return ans;
	}
	private void dfs(List<String> ans,LinkedList<String> tempAns,String s,int index,Set<String> wordDict){
		if(index == s.length()){
			StringBuilder sb = new StringBuilder();
			sb.append("\""+tempAns.get(0));
			for(int i =1;i< tempAns.size();i++){
				sb.append(" "+tempAns.get(i));
			}
			sb.append("\"");
			ans.add(sb.toString());
			return;
		}
		String tempS;
		for(int i = min; i < max+1&& i+index<= s.length();i++){
			tempS = s.substring(index,index+i);
			if(wordDict.contains(tempS)){
				tempAns.addLast(tempS);
				dfs(ans, tempAns, s, index+i, wordDict);
				tempAns.removeLast();
			}
		}
	}
	
	
}
