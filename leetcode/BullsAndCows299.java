package qiang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows299 {

	public static void main(String[] args) {
		System.out.println( new BullsAndCows299().getHint("1122", "2211"));
	}
	
	public String getHint(String secret, String guess) {
	        
		if(secret == null && guess == null) return "";
		int size = secret.length();

		Map<Character,Integer> no = new HashMap<>();
		Set<Integer> po = new HashSet<>();
		int a =0;int b =0;
		for(int i=0;i<size;i++){
			if(secret.charAt(i) == guess.charAt(i)){
				a++;
			}else{
				if(no.containsKey(secret.charAt(i))){
					no.put(secret.charAt(i), no.get(secret.charAt(i))+1);
				}else{
					no.put(secret.charAt(i),1);
				}
				po.add(i);
			}
		}
		for(int cur:po){
			if(no.containsKey(guess.charAt(cur))&&no.get(guess.charAt(cur))>0){
				b++;
				no.put(guess.charAt(cur), no.get(guess.charAt(cur))-1);
			}
		}
				
		
		return a+"A"+b+"B";
	}
	
	
}
