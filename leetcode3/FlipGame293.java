package qiang.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class FlipGame293 {
	public static void main(String[] args) {
		
		System.out.println(generatePossibleNextMoves("--++++++++"));
	}
	public static List<String> generatePossibleNextMoves(String s) {
		List<String> ans = new ArrayList<>();
		if(s == null || s.length() <2)return ans;
		for(int i =0;i< s.length()-1;i++){
			if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
				ans.add(s.substring(0,i)+"--"+s.substring(i+2));
			}
		}
		return ans;
	}
}
