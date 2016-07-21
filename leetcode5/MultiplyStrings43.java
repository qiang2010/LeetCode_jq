package qiang.leetcode5;

public class MultiplyStrings43 {

	
	
    public String multiply(String num1, String num2) {
    	
    	if(num1==null || num2 == null) return "";
    	
    	int size1 = num1.length();
    	int size2 = num2.length();
    	if(size1 == 0 || size2 == 0)return "0";
    	int n1[] =  new int[size1];
    	int n2[] =  new int[size2];
    	for(int i = size1-1;i>-1;i--){
    		n1[size1-i-1] = num1.charAt(i) -'0'; 
    	}
    	for(int j = size2-1; j>-1;j--){
    		n2[size2-1-j] = num2.charAt(j)-'0';
    	}
    	
    	int ans[] = new int[size1+size2];
    	for(int i=0;i<size1 ; i++){
    		for(int j=0;j<size2; j++){
    			ans[i+j] += n1[i]*n2[j];
    		}
    	}
    	
    	for(int i=0;i<size1+size2-1; i++){
    		ans[i+1] += ans[i]/10;
    		ans[i]   %= 10;
    	}
    	StringBuilder re = new StringBuilder();
    	int j = size1+size2-1;
    	while(j>-1 && ans[j]==0)j--;
    	for(; j>-1;j--){
    		re.append(ans[j]);
    	}
    	return re.toString();
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings43 ms = new MultiplyStrings43();
		System.out.println(ms.multiply("12222222222", "12"));
	}

}
