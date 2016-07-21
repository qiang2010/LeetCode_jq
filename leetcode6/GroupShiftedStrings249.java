package qiang.leetcode6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings249 {

	public static void main(String[] args) {
		GroupShiftedStrings249 gg = new GroupShiftedStrings249();
		String []strings ={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(gg.groupStrings(strings));
	}
	public List<List<String>> groupStrings(String[] strings) {
	     List<List<String>> ans = new ArrayList<List<String>>();
	     if(strings == null || strings.length == 0) return ans;
	     
	     Map<String,List<String>> map = new HashMap<>();
	     for(String s : strings){
	    	 String ss= this.changeOneS(s);
	    	 if(map.containsKey(ss)==false) map.put(ss, new LinkedList<String>());
	    	 map.get(ss).add(s);
	     }
	     for(List<String>sss: map.values()){
	    	 ans.add(sss);
	     }
	     return ans;
	}	
	String changeOneS(String s){
		if(s.length()==1)return "#";
		char []c = s.toCharArray();
		char a,b;
		StringBuilder sb = new StringBuilder();
		for(int i =1;i<c.length;i++){
			a = c[i-1];
			b = c[i];
			int d = (b-a +26)%26;
			sb.append(d);
		}
		return sb.toString();
	}
}
