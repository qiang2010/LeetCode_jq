package qiang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal166 {

	
	   
	
	public String fractionToDecimal(int numerator, int denominator) {
	        if(numerator == 0) return "0";
	        if(denominator == 0) return "";
	        
	        
	        StringBuilder ans = new StringBuilder();
	        if(numerator < 0 ^ denominator < 0)
	        	ans.append("-");
	
	        long num = numerator;
	        long deno = denominator;
	        num = Math.abs(num);
	        deno = Math.abs(deno);
	        
	        long res = num % deno;
	        if(res == 0){
	        	ans.append(String.valueOf((num/deno)));
	        	return ans.toString();
	        }
	        Map<Long,Integer> remMap = new HashMap<>();
	        
	        long left = num/deno;
	        ans.append(String.valueOf(left)+".");
	        
	        while(res !=0){
	        	
	        	if(remMap.containsKey(res)){
	        		int beg = remMap.get(res);
	        		String p1 = ans.substring(0,beg);
	        		String p2 = ans.substring(beg,ans.length());
	        		return p1+"("+p2+")";
	        	}
	        	
	        	remMap.put(res, ans.length());
	        	left = res*10/deno;
	        	ans.append(String.valueOf(left));
	        	res = res*10%deno;
	        }
	        return ans.toString();
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println(new FractionToRecurringDecimal166().fractionToDecimal(1, 3));
	}
}
