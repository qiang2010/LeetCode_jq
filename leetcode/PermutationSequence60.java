package qiang.leetcode;


public class PermutationSequence60 {


	public String getPermutation(int n, int k) {
		
		StringBuilder sb = new StringBuilder();
		
		// 首先构造(n-1)的阶层
		int []fa = new int[n];
		boolean visited[] = new boolean[n];
		int f=1;
		fa[0] =1;
		for(int i = 1; i < n; i++){
			f*=i;
			fa[i] = f;
			visited[i-1] = false;
			sb.append(i);
		}
		if(k == 1) {
			sb.append(n);
			return sb.toString();
		}
		else sb = new StringBuilder();
		int j = n-1;
		int temp;
		k-=1;
		while(j != 0 ){
			temp = k/fa[j];
			k = k%fa[j];
			int m = 0;
			int count = 0;
			int lastFalse=0;
			while(count < temp +1 && m<n){
				if(visited[m]== false){
					lastFalse = m;
					count++;
				}
				m++;
			}
			visited[lastFalse] = true;
			sb.append(lastFalse+1);
			j--;
		}
		//System.out.println(sb.toString());
		
		int jk = 0;
		while(jk<n && visited[jk] == true){
			jk++;
		}
		sb.append(jk+1);
		return sb.toString();
	}
	
	
    public String getPermutation2(int n, int k) {
      
    	int []nums = new int[n];
    	for(int i =0 ; i < n; i++){
    		nums[i]=i+1;
    	}
    	for(int i = 0 ; i < k; i++){
    		//System.out.println(Arrays.toString(nums));
    		NextPermutation31.nextPermutation(nums);
    		
    	}
    		
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<n;i++){
    		sb.append(nums[i]);
    	}
    	return sb.toString();
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence60 ps = new PermutationSequence60();
		System.out.println(ps.getPermutation(3, 2));
	}

}
