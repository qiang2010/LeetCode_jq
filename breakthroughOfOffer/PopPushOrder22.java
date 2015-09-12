package qiang.breakthroughOfOffer;

import java.util.LinkedList;

public class PopPushOrder22 {

	
	boolean isPopPushOrder(int []push,int []pop){
		
		if(push == null && pop == null) return true;
		if(push != null && pop == null) return false;
		if(push == null && pop != null) return false;
		if(push.length != pop.length) return false;
		if(push.length ==0 )return true;
		LinkedList<Integer> stack = new LinkedList<>();
		int pushIndex =0;
		int popIndex = 0;
		
		//stack.addLast(push[pushIndex++]);
		while(popIndex < pop.length){
			
			while(pushIndex < push.length && push[pushIndex] != pop[popIndex]){
				stack.addLast(push[pushIndex++]);
			}
			if(pushIndex == push.length) return false;
			popIndex++;
			pushIndex++;
			while(!stack.isEmpty() && popIndex < pop.length && stack.getLast() == pop[popIndex]){
				stack.removeLast();
				popIndex++;
			}
		}
		return true;
	}
	public static void main(String[] args) {

		int []push = {1};
		int []pop = {3};
		System.out.println(new PopPushOrder22().isPopPushOrder(push, pop));
		
	}

}
