package qiang.indeedTest;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int nums [] = new int[K];
		double pro[] = new double[K];
		int sum = 0;
		for(int i =0;i<K;i++){
			nums[i] = in.nextInt();
			sum += nums[i];
		}
		for(int i = 0 ; i < K;i++){
			pro[i] = nums[i]*1.0/sum;
		}
		if(K == 1) System.out.println(1);
		else
			System.out.println(String.format("%.6f",1+pro[0]/pro[1]+pro[1]/pro[0]));
	}
	
}
