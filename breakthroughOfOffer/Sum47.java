package qiang.breakthroughOfOffer;

public class Sum47 {

	
	public static void main(String[] args) {
		
		System.out.println(sum(1000000000,2));
	}
	
	static int sum(int a,int b){
		
		int sum = 0;
		
		int car;
		
		do{
			sum = a ^ b;
			car = (a & b)<<1;
			a = sum;
			b = car;
			
		}while(b !=0);
		return sum;
	}
}
