package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SimplifyPath71 {
    public static String simplifyPath(String path) {
    	
    	
        if("".equals(path.trim())) return "/";
        String []dirs = path.split("/");
    	int s = dirs.length;
    	LinkedList<String> stack = new LinkedList<>();
    	String temp;
    	for(int i = 0; i < s; i++){
    		temp = dirs[i].trim();
    		if("".equals(temp)||".".equals(temp)){
    			continue;
    		}
    		if("..".equals(temp) ){
    			if(!stack.isEmpty()){
    				stack.removeLast();
    			}
    		}else{
    			stack.addLast(temp);
    		}
    	}
    	if(stack.isEmpty()){
    		return "/";
    	}
    	StringBuilder ans = new StringBuilder();
    	
    	while(!stack.isEmpty()){
    		temp = stack.getFirst();
    		stack.removeFirst();
    		ans.append("/"+temp);
    	}
    	return ans.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 // split test
		String path = "///ko///a/../..";
		System.out.println(simplifyPath(path));
	}

}
