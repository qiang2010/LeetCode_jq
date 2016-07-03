package qiang.interview;

import java.util.Calendar;

public class TestTime {

	
	public static void main(String[] args) {
		
		int size = 10000;
		MaximumXORWithPrefixAndSuffix  ji = new MaximumXORWithPrefixAndSuffix();
		while(size <= 100000){
			test(size,ji);
			size+=10000;
		}
		
	}
	static void test(int size,MaximumXORWithPrefixAndSuffix  ji){
		System.out.println(size);
		long []nums = new long[size];
		double ex = 1e12;
		for(int i =0 ; i < nums.length;i++){
			nums[i] = (long)(Math.random()*ex);
		}
		
		
		
		long lat = Calendar.getInstance().getTimeInMillis();
		long k = MaximumXOR_xu.xu(nums);
		long cur = Calendar.getInstance().getTimeInMillis();
		System.out.println(k+"\txu:\t"+(cur-lat));
		
		long cur2 = Calendar.getInstance().getTimeInMillis();
		long j = ji.maximumXorWithPrefixAndSuffix(nums);
		long cur3 = Calendar.getInstance().getTimeInMillis();
		System.out.println(j+"\tji:\t"+(cur3-cur2));
		
		cur2 = Calendar.getInstance().getTimeInMillis();
		long v = new MaximumXORWithPrefixAndSuffix().validataion(nums);
		cur3 = Calendar.getInstance().getTimeInMillis();
		System.out.println(v+"\tvalid\t"+(cur3-cur2));
	}
}
