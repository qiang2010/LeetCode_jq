package qiang.leetcode;

public class CountAndSay {

	
	
    public String countAndSay(int n) {
    	
    	if(n==1) return "1";
    	
    	int i=1;
    	String temp = "1";
    	while(i<n){
    		temp = readOneString(temp);
    		i++;
    	}
    	
    	return temp;
    }
	private String readOneString(String cur){
		StringBuilder next = new StringBuilder();
		int size = cur.length();
		for(int i =0 ; i < size; i++){
			char a = cur.charAt(i);
			int j = i ;
			while(i+1 < size && a == cur.charAt(i+1)){
				i++;
			}
			next.append(""+(i-j+1)+a);   // 1个a
		}
		return next.toString();
	}
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay cs = new CountAndSay();
		String ans = cs.countAndSay(35);
		System.out.println(ans);
		System.out.println(ans.length());
	}

}
