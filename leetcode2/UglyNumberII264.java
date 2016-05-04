package qiang.leetcode2;

public class UglyNumberII264 {
	 
	public static void main(String[] args) {
		System.out.println(new UglyNumberII264().isUgly(14));
	}
	public boolean isUgly(int num) {
		
		if(num < 1 )return false;
		if(num == 1) return true;
		
		int a = div(num,2);
		if(a == 1) return true;
		a = div(a,3);
		if(a == 1) return true;
		a = div(a,5);
		if(a ==1) return true;
		return false;
	
	}
	int div(int num,int di){
		while(num%di==0){
			num/=di;
		}
		return num;
	}
}
