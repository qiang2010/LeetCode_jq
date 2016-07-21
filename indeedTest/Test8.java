package qiang.indeedTest;

import java.util.Scanner;



public class Test8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String S = in.next();
		int costs[] = new int[N+1];
		for(int i =0;i<N+1;i++) costs[i]=in.nextInt();
		long sum =0;
		int curMin =costs[0];
		int count =0;
		for(int i =0;i<S.length();i++ ){
			curMin = Math.min(curMin, costs[i]);
			if(S.charAt(i) =='('){
				count++;
			}else{
				count--;
			}
			if(count<0){ // 需要在前面添加一个（
				sum+=curMin;
				count++;
			}
		}
		curMin = Integer.MAX_VALUE;
		count = 0;
		S = new StringBuilder(S).reverse().toString();
		for(int i =0;i<S.length();i++ ){
			curMin = Math.min(curMin, costs[S.length()-i]);
			if(S.charAt(i) ==')'){
				count++;
			}else{
				count--;
			}
			if(count<0){ // 需要在前面添加一个（
				sum+=curMin;
				count++;
			}
		}
		System.out.println(sum);
	}
	
	
}
