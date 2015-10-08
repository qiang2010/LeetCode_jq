package qiang.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber179 {

	public String largestNumber(int[] nums) {
		
		Comparator<Integer> com = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				
				return (""+b+a).compareTo(""+a+b) ;
					
			}
		};
		
		List<Integer> numsList = new ArrayList<>();
		for(int a:nums){
			numsList.add(a);
		}
		Collections.sort(numsList,com);
		StringBuilder sb = new StringBuilder();
		int countZero=0;
		for(int a:numsList){
			if(a==0)countZero++;
			sb.append(a);
		}
		if(countZero == numsList.size())return "0";
		return sb.toString();
	}
	public static void main(String[] args) {
		
		int nums[] = {999999998,999999997,999999999};
		System.out.println(new LargestNumber179().largestNumber(nums));
	}
	
	
}
