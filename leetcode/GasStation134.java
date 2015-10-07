package qiang.leetcode;

public class GasStation134 {


	
	
	
	
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		
		if(gas == null || cost == null) return -1;
		int gasSize = gas.length;
		int costSize = cost.length;
		if(gasSize != costSize || gasSize ==0 || costSize == 0) return -1;
	
		int gasCar = 0;
		int ans =0;
		int i =0;
		int count=0;
		while(ans < gasSize){
		
			if(gasCar < 0 ){
				gasCar+=cost[ans]-gas[ans];
				ans++;
				count--;
			}else{
				gasCar += gas[i]-cost[i];
				count++;
				if(count==gasSize && gasCar > -1)return ans;
				i = (i+1)%gasSize;
			}
			
		}
		
		return -1;
	}
	
	
	   
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		if(gas == null || cost == null) return -1;
		int gasSize = gas.length;
		int costSize = cost.length;
		if(gasSize != costSize || gasSize ==0 || costSize == 0) return -1;
	
		int gasCar;
		int k,j;
		for(int i = 0 ;i < gasSize; i++){
			gasCar = 0 ;
			for(j = i,k =0 ; k < gasSize; j=(j+1)%gasSize,k++ ){
				gasCar += gas[j]-cost[j];
				if(gasCar < 0){
					break;
				}
			}
			if(k == gasSize){
				return i; 
			}
		}
		
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		int gas[]={99,98,97,100};
		int cost[]={100,100,100,97};
				
		System.out.println(new GasStation134().canCompleteCircuit2(gas, cost));
	}
}
