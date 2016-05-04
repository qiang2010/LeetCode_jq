package qiang.test;

import java.util.ArrayList;
import java.util.List;

import qiang.leetcode.util.PrintUtil;

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((2==2) &(true));
		 List<List<Integer>> res =new ArrayList<>();
		List<Integer> aCombo = new ArrayList<>();
        aCombo.add(4);
        aCombo.add(61);
        res.add(new ArrayList<Integer>(aCombo));
        PrintUtil.print2DList(res);
        System.out.println("1111111");
        aCombo.set(0, aCombo.set( 1,aCombo.get(0) ) );
        res.add(aCombo);
        PrintUtil.print2DList(res);
	
        char a = '我';
        System.out.println(a);
        	
        switch ("aa") {
		case "b":
			System.out.println("bbb");
			break;
		case "aa":
			System.out.println("aaa");
		default:
			break;
		}
        
        Integer a1 = 12;
        Integer a2 = 12;
        System.out.println(a1==a2);
        
        
	}
	
}
