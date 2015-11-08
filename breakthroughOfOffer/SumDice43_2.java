package qiang.breakthroughOfOffer;

public class SumDice43_2 {

	
	public static void main(String[] args) {
		
		new SumDice43_2().sumDice(2);
		
		
	}
	void sumDice(int n){
		
		if(n < 1) return;
		int size = 6*n+1;
		int []count = new int[size];
		// 一个骰子的情况
		for(int i =1; i < 7; i++){
			count[i]++;
		}
		
		for(int i =2; i < n+1; i ++){
			int j = i*6;
			int sum = 1;
			for(; j>0;j--){
				count[j] = sum;
				sum -= count[j-1];
				if(j > 7)
					sum+= count[j-7];
			}
		}
		for(int a:count){
			System.out.println(a);
		}
	}
 
}
