package qiang.leetcode;

public class StringToInteger8 {
	  
	public static void main(String[] args) {
		
		System.out.println(new StringToInteger8().myAtoi("9223372036854775809"));
	}
	
	
	public int myAtoi(String str) {
	        
		if(str == null) return 0;
		str = str.trim();
		if(str.length()==0) return 0;
		
		long ans =0;
		int i=0;
		int op = 1;
		char cur = str.charAt(0);
		if(cur =='+'){
			op=1;i++;
		}else{
			if(cur=='-'){
				op=-1;i++;
			}else{
				if(cur <'0' || cur >'9'){
					return 0;
				}
			}
		}
		int fir = i;
		if(i == str.length())return 0;
		//cur = str.charAt(i++);
		while(i<str.length()){
			cur = str.charAt(i);
			if(cur <'0' || cur >'9'){
				break;
			}
			i++;
		}
		if(i-fir >11){
			if(op > 0) return Integer.MAX_VALUE;
			else{
				return Integer.MIN_VALUE; 
			}
		}
		long base=1;
		//i = ( (i == str.length()-1)? str.length():i);
		for(int j = i-1; j > fir-1;j--){
			ans+= (str.charAt(j)-'0')*base;
			base*=10;
		}
		ans *= op;
		if(ans > Integer.MAX_VALUE)return Integer.MAX_VALUE;
		if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int)ans;
	}
}
