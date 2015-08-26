package qiang.mergeInterval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals56 {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans =new  LinkedList<Interval>();
        if(intervals == null || intervals.size() ==0) return ans;
    	if(intervals.size()==1) return intervals;
    	Comparator<Interval> com = new Comparator<Interval>() {
			@Override
			public int compare(Interval arg0, Interval arg1) {
				// TODO Auto-generated method stub
				int k = arg0.start - arg1.start;
				if(k<0) return -1;
				if(k>0) return 1;
				return arg0.end - arg1.end;
			}
		};
		
		Collections.sort(intervals,com);
    	int size = intervals.size();
    	
    	Interval curI = intervals.get(0);
    	Interval next ;
    	for(int i=1; i< size; i++){
    		next = intervals.get(i);

    		if(next.start <= curI.end ){
    			if(next.end >= curI.end) {
    				curI.end = next.end;
    		    }
    			if(i == size -1){
					ans.add(curI);
					System.out.println(curI.start +" " + curI.end);
				}
    		}else{
    			System.out.println(curI.start +" " + curI.end);
    			ans.add(curI);
    			if(i == size -1 ){
    				ans.add(next);
    				System.out.println(next.start +" " + next.end);
    			}
    			curI = next;
    		}
 
    	}
    	
    	return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals56 mi = new MergeIntervals56();
		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(1,13));
		intervals.add(new Interval(2,3));
//		intervals.add(new Interval(2,6));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(15,18));
		System.out.println(mi.merge(intervals).size());
	}

}
