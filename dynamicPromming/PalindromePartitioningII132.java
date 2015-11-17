package qiang.dynamicPromming;

public class PalindromePartitioningII132 {

	  
	public static void main(String[] args) {
		
		PalindromePartitioningII132 pp = new PalindromePartitioningII132();
		System.out.println(pp.minCut("abcdef"));
	}
	
	public int minCut(String s) {
	       
		int size = s.length();
		if(size < 2) return 0;
		int []cuts = new int[size+1];
		for(int i = 0;i<size+1;i++){
			cuts[i] = size-i-1;
		}
		boolean [][]isPal = new boolean[size][size];
	
		for(int i =size-1;i> -1;i--){
			for(int j = i;j<size;j++){
				
				if(j-i <1 || j-i <2 && s.charAt(i)==s.charAt(j)|| s.charAt(i)==s.charAt(j)&& isPal[i+1][j-1]){
					isPal[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
				}else{
					isPal[i][j]= false;
				}
			}
		}
		return cuts[0];
	}
	
	
	
}
