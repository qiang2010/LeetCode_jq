package qiang.hiho.hiho1;

import java.util.Scanner;

public class FontSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FontSize df = new FontSize();
		df.process();
	}
	
	void process(){
		
		Scanner in = new Scanner(System.in);
		int testN = in.nextInt();
		for(int i =0;i< testN;i++){
			int N = in.nextInt();
			int P = in.nextInt();
			int W = in.nextInt();
			int H = in.nextInt();
			int []sizes = new int[N];
			for(int j = 0 ; j < N;j++){
				sizes[j] = in.nextInt();
			}
			int s = 1;
			while(isOk(N, P, W, H, sizes, s)) s=s<<1;;
			int begin = s >>1;
			int end = s;
			while(true){
				int mid = (begin + end)>>1;
				if(isOk(N, P, W, H, sizes, mid)){
					begin = mid;
					
				}else{
					end = mid;
				}
				if(begin+1==end){
					System.out.println(begin);
					break;
				}
			}
		}
		in.close();
		
	}
	boolean isOk(int n,int p,int w,int h,int sizes[],int s){
		int sum = 0;
		int onelineW = w/s;
		for(int one:sizes){
			sum += Math.ceil(one*1.0/onelineW);
		}
		if(p*(h/s) >= sum)return true;
		return false;
	}
}
