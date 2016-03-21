package qiang.leetcode2;


public class BasicCalculator224 {
	public static void main(String[] args) {
		
		System.out.println(calculate("6-(1+3)"));
	}
	/**
	 * 使用递归来做
	 * @param s
	 * @return
	 */
	static int pos = 0;
	public static int calculate(String s) {
		if(s == null || "".equals(s.trim()))return 0;
		int size = s.length();
		int sum = 0;
		boolean plus = true;
		while(pos < size ){
			switch(s.charAt(pos)){
			case ' ':
				pos++;break;
			case '(':
				pos++;
				sum += plus? calculate(s):-calculate(s);
				break;
			case '+':
				pos++;
				plus = true;
				break;
			case '-':
				pos++;
				plus = false;
				break;
			case ')':
				pos++;
				return sum;
			default: // 数字
				int num = 0;
				while(pos<size && Character.isDigit(s.charAt(pos))){
					num*=10;
					num += (s.charAt(pos)-'0');
					pos++;
				}
				sum +=plus?num:-num;
			}
			
		}
		return sum;
	}
}
