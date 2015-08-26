package qiang.mergeInterval;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	
	
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	
    	List<Interval> ans = new LinkedList<>();
    	if(intervals == null || intervals.size()==0){
    		ans.add(newInterval);
    		return ans;
    	}
    	
    	int size = intervals.size();
    	Interval tempInt;
    	int newS = newInterval.start,newE = newInterval.end;
    	int i=0;
    	// 从左边开始找，不是找位置，而是找新的Interval的左边界
    	// 跳出循环的i表示的是处理到的interval，或者包含了newInterval或者a刚好小于其start。
    	for( i =0;i<size; i++){
    		tempInt = intervals.get(i);
    		if(newS < tempInt.start) {
    			break;
    		}
    		if(newS <= tempInt.end){
    			newS = tempInt.start;
    			break;
    		}
    		ans.add(tempInt);
    	}
    	// 未找到 a
    	if(i == size){
    		tempInt = new Interval(newS,newE);
    		ans.add(tempInt);
    		return ans;
    	}
    	
    	
    	// 找到b的位置。
    	int k;
    	for( k =i; k < size; k++){
    		tempInt = intervals.get(k);
    		if(newE < tempInt.start){
    			k--;
    			break;
    		}
    		if(newE <= tempInt.end){
    			newE = tempInt.end;
    			break;
    		}
    	}
    	tempInt = new Interval(newS,newE);
    	ans.add(tempInt);
    	// 将 k+1 后面的都加入到ans
    	for( int n = k+1; n < size; n++){
    		ans.add(intervals.get(n));
    	}
    	return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval it = new InsertInterval();
		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(1,13));
		intervals.add(new Interval(15,90));
//		intervals.add(new Interval(2,6));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(15,18));
		List<Interval> ans = it.insert(intervals, new Interval(15,16));
		int i = 0;
		while(i <  ans.size()){
			System.out.println(ans.get(i).start + " " + ans.get(i).end);
			i++;
		}
	}

}
