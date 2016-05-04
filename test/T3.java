package qiang.test;

import java.util.ArrayList;
import java.util.List;

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 11;
//		b = b+1;
		System.out.println(Integer.toBinaryString(100));
		System.out.println(Integer.toBinaryString(-100));
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i));
			list.remove(i);
		}
		double a = Math.log(9)/Math.log(3);
		System.out.println(Double.toString(a)+"  "+a);
		String bd ="";
	}

}
