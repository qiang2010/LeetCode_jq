package qiang.indeedTest;

import java.util.Scanner;

public class Test2 {

 
	private static int Permutation(int nums[]){
		int n = nums.length-1;
		int ans = 0;
		for(int i=1;i<=n;++i)
			if(nums[i]>=1){
				++ans;
				dfs(i,nums);
			}
		return ans;
	}
	private static void dfs(int i,int nums[]){
		if(nums[i]<1) return;
		int tmp = nums[i];
		nums[i]=0;
		dfs(tmp,nums);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n= Integer.valueOf(in.next());
		int nums[] = new int[n+1];
		for(int i=1;i<=n;++i)
			nums[i] = Integer.valueOf(in.next());
		System.out.println(Permutation(nums));
	}
}