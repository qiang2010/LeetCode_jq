package qiang.indeedTest;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B=  in.nextInt();
		int K = in.nextInt();
		double i = 0, j = 0.5;
		int count = 0, flag = 0;
		while (count < K){
			if ((i + A) < (j + B)){
				i += A;
				flag = 0;
			}else{
				j += B;
				flag = 1;
			}
			count ++;
		}
		if (flag == 0) 
			System.out.println("Takahashi");
		else System.out.println("Aoki");
		in.close();
	}

}
