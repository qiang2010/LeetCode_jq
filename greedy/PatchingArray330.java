package qiang.greedy;

public class PatchingArray330 {
    public static void main(String[] args) {
    	PatchingArray330 pp = new PatchingArray330();
    	int []nums = {1, 5, 10};
    	int n =20;
    	
    	System.out.println(pp.minPatches(nums, n));
    	
	}
	public int minPatches(int[] nums, int n) {
		if(nums == null || nums.length==0)return 0;
		if(n <1)return 0;
		int patch = 0;
		long cover = 0;
		
		for(int i =0;i< nums.length;i++){
			
			if(cover >=n)return patch;
			while(nums[i]-cover >1){
				patch++;
				cover = cover*2+1;
				if(cover >=n)return patch;
			}
			cover += nums[i];
			
		}
		while(cover < n){
			cover*=2+1;
			patch++;
		}
		return patch;
    }
}
