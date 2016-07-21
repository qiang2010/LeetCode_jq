package qiang.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII247 {
	
	public static void main(String[] args) {
		StrobogrammaticNumberII247 st = new StrobogrammaticNumberII247();
		List<String > ans = new LinkedList<>();
		char [] candy = {'0','1','6','8','9'};
		Map<Character,Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		int n =3;
		boolean flag = false;
		if((n&1)==1)flag = true;
		st.dfs(candy, map, 0, n/2, flag, new StringBuilder(), ans);
		System.out.println(ans.toString());
	}
	
	void dfs(char [] candy, Map<Character,Character> map, int curIndex, int half, boolean flag,StringBuilder sb, List<String> ans){
        
	     if( curIndex == half ){
	          if(flag){             
	               StringBuilder anssb = new StringBuilder(sb);
	               anssb.append('0'); 
	               for(int i =sb.length()-1;i>-1 ;i--){
	                      anssb.append( map.get(sb.charAt(i)));
	               }
	               ans.add(anssb.toString());
	               anssb.setCharAt(half,'1');
	               ans.add(anssb.toString());
	               anssb.setCharAt(half,'8');
	               ans.add(anssb.toString());
	               return;
	          }else{
	                StringBuilder anssb = new StringBuilder(sb);
	               for(int i =sb.length()-1;i>-1 ;i--){
	                      anssb.append( map.get(sb.charAt(i)));
	               }
	               ans.add( anssb.toString());
	          }
	          return;
	     }
	     // dfs
	     for(int i =0;i< candy.length;i++){
	          char c = candy[i];
	          if( curIndex == 0 && c=='0') continue;
	          sb.append(c);
	          dfs(candy, map, curIndex+1,half, flag,sb,ans);
	          sb.deleteCharAt(sb.length()-1);
	     }

	}
	String getOneAns(StringBuilder sb, char c, Map<Character,Character> map ){
	     StringBuilder ans = new StringBuilder(sb);
	     ans.append(c); 
	     for(int i =sb.length()-1;i>-1 ;i--){
	            ans.append( map.get(sb.charAt(i)));
	     }
	     return ans.toString();
	}

}
