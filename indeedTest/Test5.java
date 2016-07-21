package qiang.indeedTest;

import java.util.*;
public class Test5 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s= in.nextLine();
		String t= in.nextLine();
		in.close();
		String posssible = "Possible";
		String impossbile = "Impossible";
		if (s.equals(t)) {
			System.out.println(posssible);
			return;
		}
		int size = s.length();
		if (size != t.length()) {
			System.out.println(impossbile);
			return;
		}
		HashSet<Character> hashSet = new HashSet<>();
		for (int i = 0; i < size; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				hashSet.add(s.charAt(i));
				hashSet.add(t.charAt(i));
			}
		}
		if (hashSet.size()>2) {
			System.out.println(impossbile);
		}else {
			System.out.println(posssible);
		}
	}

}
