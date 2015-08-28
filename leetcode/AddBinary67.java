package qiang.leetcode;

public class AddBinary67 {

    public static String addBinary(String a, String b) {
     
    	if(a == null ||"".equals(a.trim())) return b;
    	if(b == null || "".equals(b.trim())) return a;
    	
    	StringBuilder ans = new StringBuilder();
    	int size1 = a.length();
    	int size2 = b.length();
    	int s = size2;
    	// 这样 a就是较长的字符串了。
    	String tempStr;
    	if(size1 < size2){
    		tempStr = a;
    		a = b;
    		b =  tempStr;
    		s = size1;
    		size1 = size2;
    		size2 = s;
    	}
    	int carr =0;
    	int temp ;
    	
    	for(int i = s-1; i >-1; i--){
    		temp = a.charAt(i+size1-size2)-'0' + b.charAt(i)-'0' + carr;
    		ans.append(temp%2);
    		carr= temp/2;
    	}
    	
    	for(int i = size1-s -1; i>-1; i--){
    		temp = a.charAt(i)-'0' + carr;
    		ans.append(temp%2);
    		carr= temp/2;
    	}
    	if(carr != 0) ans.append(carr);
    	ans.reverse();
    	return ans.toString();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11111", "1111"));
	}

}
