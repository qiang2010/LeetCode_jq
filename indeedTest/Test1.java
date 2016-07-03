package qiang.indeedTest;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
		 
		 String lin = in.next();
		 for(char a : lin.toCharArray()){
			 if( a <= 'z' && a >='a')System.out.print(a);
			 else System.out.println();
		 }
		 in.close();
	}
}
