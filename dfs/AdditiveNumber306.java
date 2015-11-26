package qiang.dfs;

public class AdditiveNumber306 {

	
	  
	public static void main(String[] args) {
		
		AdditiveNumber306 sn = new AdditiveNumber306();
		System.out.println(sn.isAdditiveNumber("211738"));
		  
	}
	
	public boolean isAdditiveNumber(String num) {
	     
		if(num == null || num.length() == 0) return false;
		long first,second;
//		if(num.charAt(0)=='0') 
//			return dfs(num, 1, 0,0);
		for(int i = 0 ; i< num.length()-1;i++){
			first = Long.parseLong(num.substring(0, i+1));
			int digis = digisN(first);
			if(digis<i+1)break;
			if(digis > (num.length()+1)/2)break;
			for(int j = i+1;j<num.length();j++){
				second = Long.parseLong(num.substring(i+1,j+1));
				int secDig = digisN(second);
				if(secDig < j-i)break;
				if(Math.max(digis, secDig)>num.length()-j-1)break;
				if(dfs(num, j+1, second,first))return true;
			}
		}
		return false;
	}
	
	boolean dfs(String num,int curIndex,long lastNum,long beforeLast){
		if(curIndex > num.length()-1)return true;
		if(curIndex > 0 && num.charAt(curIndex)=='0') return false;
		boolean flag = false;
		long curSum = lastNum + beforeLast;
			
		int dig = digisN(curSum);
			
		if(dig+curIndex>num.length())return false; // 后面无需判断，已经超界了。
			
		if((curSum+"").equals(num.substring(curIndex, dig+curIndex))){
			flag = dfs(num, dig+curIndex, curSum,lastNum);
			if(flag )return true;
		}
		return false;
	}
	int digisN(long nu){
		if(nu == 0)return 1;
		int c =0;
		while(nu!=0){
			c++;
			nu/=10;
		}
		return c;
	}
	
}
