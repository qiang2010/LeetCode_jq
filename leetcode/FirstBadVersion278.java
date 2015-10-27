package qiang.leetcode;

public class FirstBadVersion278 {
	
	public static void main(String[] args) {
		
		System.out.println(new FirstBadVersion278().firstBadVersion(3));
	}
	
	public int firstBadVersion(int n) {
	        
		return bad(1, n);
	
	}
	int bad(long begin,long end){
		
		long mid;
		while(begin <= end){
			mid = (begin + end)/2;
			if(isBadVersion((int)mid)){
				end = mid-1;
			}else{
				begin = mid + 1;
			}
		}
		return (int)begin;
	}
	boolean isBadVersion(int version){
		if(version >= 2)return true;
		return false;
	};
}
