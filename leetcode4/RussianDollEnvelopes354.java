package qiang.leetcode4;

import java.util.Arrays;
import java.util.Comparator;


public class RussianDollEnvelopes354 {

	
	public static void main(String[] args) {
		
		int []ss =  {1,3,5,7};
		System.out.println(Arrays.binarySearch(ss,4));
		
		int a[] = new int[] {1, 3, 4, 6, 8, 9};
		int x1 = Arrays.binarySearch(a, 5);
		int x2 = Arrays.binarySearch(a, 4);
		int x3 = Arrays.binarySearch(a, 0);
		int x4 = Arrays.binarySearch(a, 10);
		System.out.println("x1:" + x1 + ", x2:" + x2);
		System.out.println("x3:" + x3 + ", x4:" + x4);
	}
	
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null) return 0;
        if(envelopes.length < 2) return envelopes.length;
        Comparator<int[]> com = new Comparator<int[]>(){
            
            public int compare(int []o1,int[]o2){
                
                if(o1[0] != o2[0] ){
                    return Integer.compare(o1[0],o2[0]);
                } 
                return Integer.compare(o2[1],o1[1]);
            }
        };
        Arrays.sort(envelopes,com);
        int len = 0;
        int []dp = new int[envelopes.length];
        for(int []on: envelopes){
            int index = Arrays.binarySearch(dp,0,len,on[1]);
            if(index < 0){
                index = -(index+1);
            }
            dp[index] = on[1];
            if(index == len) len++;
        }
        return len;
    }
    
    
	
	
}
