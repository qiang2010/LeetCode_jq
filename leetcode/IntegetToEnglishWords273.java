package qiang.leetcode;

public class IntegetToEnglishWords273 {
	
	public static void main(String[] args) {
		
		System.out.println(new IntegetToEnglishWords273().numberToWords(1000000));
	}
	
	public String numberToWords(int num) {
	
		if(num == 0) return "Zero";
		String []split ={"Thousand","Million","Billion"};
		String ans;
		int threeNum;
		threeNum = num%1000;
		ans = threeDigitToString(threeNum);
		num /=1000;
		int i=0;
		while(num != 0){
			threeNum = num%1000;
			String temp =threeDigitToString(threeNum);
			if(!temp.equals(""))
				ans = temp+" "+split[i]+" "+ans;
			i++;
			num /=1000;
		}
		
		return ans.trim().replaceAll("\\s+", " ");
	}

	public String threeDigitToString(int num){
		String one[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
				"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
		String two[] = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	    String three = "Hundred";
		if(num ==0) return "";
		if(num <21){
			return one[num];
		}
		int last2 = num%100;
		int three3 = num/100;
		StringBuilder sb = new StringBuilder();
		if(three3 >0){
			sb.append(one[three3]+" "+three);
		}
		if(last2 == 0)return sb.toString();
		if(last2 < 21){
			sb.append(" "+one[last2]);
			return sb.toString();
		}
		int two2 = last2/10;
		int one1 = last2%10;
		sb.append(" "+two[two2]+" ");
		if(one1 == 0) return sb.toString();
		sb.append(one[one1]);
		return sb.toString();
	}
}
