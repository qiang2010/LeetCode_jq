package qiang.dfs;
import java.util.HashMap;
import java.util.Map;
public class FlipGameII294 {
	public static void main(String[] args) {
		System.out.println(new FlipGameII294().canWin("+++++"));

	}
	public  boolean canWin(String s) {
		return dfs(s,new HashMap<String,Boolean>());
	}
	boolean dfs(String s, Map<String,Boolean> cache){
		if( cache.containsKey(s)){
			return cache.get(s);
		}
		for(int i = 1;i < s.length();i++){
			if(s.charAt(i) == '+' && s.charAt(i-1)=='+'){
				String newS = s.substring(0,i-1)+"--"+s.substring(i+1);
				if(!dfs(newS,cache)){
					cache.put(s, true);
					return true;
				}
			}
		}
		cache.put(s, false);
		return false;
	}
}
