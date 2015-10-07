package qiang.leetcode;


public class Candy135 {

	
	
	/**
	 *  candy2 和 3 方法只能通过若干case，判断比较复杂，这里采用一种比较简单的方法。
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		
		int ans = 0;
		if(ratings==null || ratings.length==0)return ans;
		if(ratings.length < 2) return ratings.length;
		
		int size = ratings.length;
		int candys[] = new int[size];
		
		int j=0;
		for(int i = 0 ;i < size; i++){
			j=1;
			candys[i] = 1;
			while(i+1<size && ratings[i]<ratings[i+1]){
				candys[++i] = ++j;
			}
		}
		//System.out.println(candys.toString());

		for(int i = size-1 ;i > -1; i--){
			j=1;
			while(i-1>-1  && ratings[i]<ratings[i-1]){
				++j;
				--i;
				candys[i] = candys[i] > j ? candys[i] :j; 
			}
		}
		for(int a:candys){
			ans+=a;
//			System.out.print(a+" ");
		}
		
//		System.out.println();
		return ans;
	}
    
	
	public int candy2(int[] ratings) {

        
		int ans = 0;
		if(ratings==null || ratings.length==0)return ans;
		if(ratings.length < 2) return ratings.length;
		
		int size = ratings.length;
 
		// 默认 false 是递减的，true是递增的。
		boolean lastSegType = false;
		boolean currentSegType = false;
		int lastSegLen = 0;
		int currentSegLen = 0;
		int lastSegFirstIndex,lastSegLastIndex;
		int currentSegFirstIndex,currentSegLastIndex;
		int i =0;
		lastSegFirstIndex = i;
		while(i+1<size && ratings[i]<ratings[i+1]){
			i++;
			lastSegType = true; // true 为递增。
		}
		if(lastSegType){  // 递增
			lastSegLastIndex = i;
			lastSegLen = i+1-lastSegFirstIndex;
		}else{
			// 递减
			while(i+1<size && ratings[i]>ratings[i+1]){
				i++;
				lastSegType = false; // fasle 为递减。
			}
			// 说明是 3 3 这种情况了。
			if(i == lastSegFirstIndex){
				lastSegLen = 1;
				lastSegLastIndex = lastSegFirstIndex;
			}else{
				// 递减模式了
				lastSegLastIndex = i;
				lastSegLen = i+1-lastSegFirstIndex;
			}
		}
		if(i == size-1){
			return size*(size+1)/2;
		}
		i++;
		for(;i < size; i++){
			currentSegType = false;
			currentSegFirstIndex = i;
			while(i+1<size && ratings[i]<ratings[i+1]){
				i++;
				currentSegType = true; // true 为递增。
			}
			if(currentSegType){
				currentSegLastIndex = i;
				currentSegLen = currentSegLastIndex - currentSegFirstIndex+1;
			}else{
				while(i+1<size && ratings[i]>ratings[i+1]){
					i++;
					currentSegType = false; // fasle 为递减。
				}
				// 3 3 这种情况。
				if(i == currentSegFirstIndex){
					currentSegLen = 1;
					currentSegLastIndex = currentSegFirstIndex;
				}else{
					currentSegLastIndex = i;
					currentSegLen = currentSegLastIndex + 1 - currentSegFirstIndex;
				}
			}
			
			// last 和 current都已经搞定了。
			if(lastSegLen == 1){  // 3 3 5 7 这种  2 3 3 3 4 5 中间的3 的candy为1.
				ans+=1;
			}else{
				// 2 3 3 这种，或者 4 3 2 1 1 这种。
				if(currentSegLen == 1){
					if(ratings[lastSegLastIndex] == ratings[currentSegFirstIndex]){
						ans+= lastSegLen*(lastSegLen+1)/2;
					}else{
						if(!lastSegType && lastSegLen > 1)ans+=1;// 5 2 3 3 => 2 1 2 1 
						ans+= lastSegLen*(lastSegLen+1)/2;
					}
				}else{
					// 都不为1的时候。
					int base = lastSegLen*(lastSegLen+1)/2;
					// 上一个为增
					if(lastSegType ){
						if(currentSegType){ // 增增
							ans+=base;
						}else{// 增减
							
							if(ratings[lastSegLastIndex] != ratings[currentSegFirstIndex] ){
								currentSegFirstIndex = lastSegLastIndex ;
								currentSegLen++;
								lastSegLen--;
								ans+=lastSegLen*(lastSegLen+1)/2;
							}else{
								ans+=base;
							}
						}
					// 上一个为减
					}else{
						if(currentSegType){ // 减增
							if(ratings[lastSegLastIndex] != ratings[currentSegFirstIndex] ){
								currentSegFirstIndex = lastSegLastIndex ;
								currentSegLen++;
								lastSegLen--;
								ans+=lastSegLen*(lastSegLen+1)/2+lastSegLen ;
							}else{
								ans+=base;
							}
						}else{// 减减
							ans+=base;
						}
						
						
					}
				}
			}
			lastSegFirstIndex = currentSegFirstIndex;
			lastSegLastIndex = currentSegLastIndex;
			lastSegLen = currentSegLen;
			lastSegType = currentSegType;
		}
		
		// 处理最后最后一个seg
		ans+=currentSegLen*(currentSegLen+1)/2;
		
		return ans;
	
		
	}
	
	
	
	
	public int candy3(int[] ratings) {
        
		int ans = 0;
		if(ratings==null || ratings.length==0)return ans;
		if(ratings.length < 2) return ratings.length;
		
		int size = ratings.length;
 
		// 默认 false 是递减的，true是递增的。
		boolean lastSegType = false;
		boolean currentSegType = false;
		int lastSegLen = 0;
		int currentSegLen = 0;
		int lastSegFirstIndex,lastSegLastIndex;
		int currentSegFirstIndex,currentSegLastIndex;
		int i =0;
		lastSegFirstIndex = i;
		while(i+1<size && ratings[i]<ratings[i+1]){
			i++;
			lastSegType = true; // true 为递增。
		}
		if(lastSegType){  // 递增
			lastSegLastIndex = i;
			lastSegLen = i+1-lastSegFirstIndex;
		}else{
			// 递减
			while(i+1<size && ratings[i]>ratings[i+1]){
				i++;
				lastSegType = false; // fasle 为递减。
			}
			// 说明是 3 3 这种情况了。
			if(i == lastSegFirstIndex){
				lastSegLen = 1;
				lastSegLastIndex = lastSegFirstIndex;
			}else{
				// 递减模式了
				lastSegLastIndex = i;
				lastSegLen = i+1-lastSegFirstIndex;
			}
		}
		if(i == size-1){
			return size*(size+1)/2;
		}
		i++;
		for(;i < size; i++){
			currentSegType = false;
			currentSegFirstIndex = i;
			while(i+1<size && ratings[i]<ratings[i+1]){
				i++;
				currentSegType = true; // true 为递增。
			}
			if(currentSegType){
				currentSegLastIndex = i;
				currentSegLen = currentSegLastIndex - currentSegFirstIndex+1;
			}else{
				while(i+1<size && ratings[i]>ratings[i+1]){
					i++;
					currentSegType = false; // fasle 为递减。
				}
				// 3 3 这种情况。
				if(i == currentSegFirstIndex){
					currentSegLen = 1;
					currentSegLastIndex = currentSegFirstIndex;
				}else{
					currentSegLastIndex = i;
					currentSegLen = currentSegLastIndex + 1 - currentSegFirstIndex;
				}
			}
			
			// last 和 current都已经搞定了。
			if(lastSegLen == 1){  // 3 3 5 7 这种  2 3 3 3 4 5 中间的3 的candy为1.
				ans+=1;
			}else{
				// 2 3 3 这种，或者 4 3 2 1 1 这种。
				if(currentSegLen == 1){
					if(ratings[lastSegLastIndex] == ratings[currentSegFirstIndex]){
						ans+= lastSegLen*(lastSegLen+1)/2;
					}else{
						if(!lastSegType && lastSegLen > 1)ans+=1;// 5 2 3 3 => 2 1 2 1 
						ans+= lastSegLen*(lastSegLen+1)/2;
					}
				}else{
					// 都不为1的时候。
					int base = lastSegLen*(lastSegLen+1)/2;
					// 上一个为增
					if(lastSegType ){
						if(currentSegType){ // 增增
							ans+=base;
						}else{// 增减
							
							if(ratings[lastSegLastIndex] != ratings[currentSegFirstIndex] ){
								ans+=lastSegLen*(lastSegLen+1)/2;
								ans+=(currentSegLen+1-lastSegLen);
							}else{
								ans+=base;
							}
						}
					// 上一个为减
					}else{
						if(currentSegType){ // 减增
							if(ratings[lastSegLastIndex] != ratings[currentSegFirstIndex] ){
								currentSegFirstIndex = lastSegLastIndex ;
								currentSegLen++;
								lastSegLen--;
								ans+=lastSegLen*(lastSegLen+1)/2+lastSegLen ;
							}else{
								ans+=base;
							}
						}else{// 减减
							ans+=base;
						}
						
						
					}
				}
			}
			lastSegFirstIndex = currentSegFirstIndex;
			lastSegLastIndex = currentSegLastIndex;
			lastSegLen = currentSegLen;
			lastSegType = currentSegType;
		}
		
		// 处理最后最后一个seg
		ans+=currentSegLen*(currentSegLen+1)/2;
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int ratings []={58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		System.out.println(new Candy135().candy(ratings));
		
	}
}
