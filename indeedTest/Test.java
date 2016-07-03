package qiang.indeedTest;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int first = in.nextInt();
		int second = in.nextInt();
		int last = in.nextInt();
		String tet = in.next();
		System.out.println((first+second + last)+" "+tet.trim());
		in.close();
	}
}
