package qiang.breakthroughOfOffer;

public class ContinueIntSum41 {

	public static void main(String[] args) {
		
		countinueIntSum(15);
	}
	
	static void countinueIntSum(int target){
		
		if(target == 1){
			System.out.println(1);
			return;
		}
		if(target ==2){
			return;
		}
		int small =1;
		int big = 2;
		int sum = small + big;
		int thres = (1+target)/2;
		while(big < thres+1){
			
			if(sum == target){
				System.out.println(small +" "+big);
				big++;
				sum+=big;
			}
			
			if(sum < target){
				big++;
				sum+=big;
			}else{
				sum-=small;
				small++;
			}
			
		}
		
	}
	
}
