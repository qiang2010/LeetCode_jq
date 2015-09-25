package qiang.point;

import java.util.Collections;
import java.util.HashMap;

public class MaxPointsonALine149 {

	   
	
	public int maxPoints(Point[] points) {
	        
	    if(points == null) return 0;
	    int size = points.length;
	    if( size < 3 ) return size;
	
	    Point first, second;
	    int max = Integer.MIN_VALUE;
	    HashMap<Double,Integer> mp = new HashMap<Double,Integer>();
	    int same;
	    double k;
	    // 重合的点单独统计，因为所有的和first相同的点，都是在所有的直线上的。
	    // （x2-x1）*（y-y1）= (y2-y1)*(x - x1)
	    for(int i = 0 ; i < size; i++){
	    	first = points[i];
	    	mp.clear();
	    	same = 0;
	    	for(int j = 0; j < size; j ++ ){
	    		second = points[j];
	    		
	    		if(first.x == second.x && first.y == second.y){
	    			same++;
	    			continue;
	    		}
	    		if(first.x == second.x){
	    			k = Double.MAX_VALUE;
	    		}else{
	    			k = (second.y-first.y)/((second.x-first.x*1.0)*1.0);
	    		}
	    		
	    		if(mp.containsKey(k)){
	    			mp.put(k, mp.get(k)+1);
	    		}else{
	    			mp.put(k, 1);
	    		}
	    	}
	    	// 找到最大值。
	    	int tempMax = same;
	    	if(!mp.isEmpty()){
	    		tempMax += Collections.max(mp.values());
	    	}
	    	if(tempMax > max){
	    		max = tempMax;
	    	}
	    }
	    return max;
	}
	
	
	public static void main(String[] args) {

	}

}
