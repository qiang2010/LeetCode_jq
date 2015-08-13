package qiang.leetcode;

import java.util.ArrayList;

public class RomanToInteger13 {

	
	private int charToInt(char a){
		switch(a){
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}
	
    public int  romanToInt(String s) {
    	if(s == null || "".equals(s.trim())) return 0;
    	int ans =  charToInt(s.charAt(s.length()-1)); ; 
    	int size = s.length();
    	int cur,next;
    	for(int i = size -2; i>=0; i--){
    		cur = charToInt(s.charAt(i+1));
    		next = charToInt(s.charAt(i));
    		if(cur <= next) ans+= next;
    		else ans -= next;
    	}
    	return ans;
    }
    
   public String intToRoman(int num) {
       StringBuilder res = new StringBuilder(); 
	   ArrayList<Integer> digs = new ArrayList<Integer>();
	   int  i = 0 ; 
	   while(i !=4){
		   digs.add(num%10);
		   num /= 10;
		   i++;
	   }
	   res.append(convert(digs.get(3),'M',' ',' '));
	   res.append(convert(digs.get(2),'C','D','M'));
	   res.append(convert(digs.get(1),'X','L','C'));
	   res.append(convert(digs.get(0),'I','V','X'));
	   return res.toString();
    }
   public String convert(int dig, char one ,char five ,char ten){
	   StringBuilder ans = new StringBuilder();
	   switch (dig) {
	   	case 9:
	   		ans.append(one);
	   		ans.append(ten);
	   			break;
	   	case 8:
	   	case 7:
	   	case 6:
	   	case 5:
	   		ans.append(five);
	   		for(int i = 5;i<dig;i++)
	   			ans.append(one);
   			break;
	   	case 4:
	   		ans.append(one);
	   		ans.append(five);
   			break;
	   	case 3:
	   	case 2:
	   	case 1:
	   		for(int i = 0 ; i < dig;i++)
	   			ans.append(one);
   			break;
	   	default:
	   		break;
	}
	   return ans.toString();
			  
   }
   
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger13 rom = new RomanToInteger13();
		System.out.println(rom.romanToInt("MDCCCLXXXVIII"));
		System.out.println(rom.intToRoman(1888));
	}

}
