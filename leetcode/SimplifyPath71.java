package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        if("".equals(path.trim())) return "/";
        String []dirs = path.split("/");
    	int s = dirs.length;
    	List<String> dirsFilter = new LinkedList<String>();
    	String temp;
    	for(int i = 0; i < s; i++){
    		temp = dirs[i].trim();
    		if("".equals(temp)||".".equals(temp)){
    			continue;
    		}
    		dirsFilter.add(temp);
    	}
    	s = dirsFilter.size();
    	if(s==0)return "/";
    	int i=s-1;
    	int doubleP = 0;
    	for( i= s-1; i > -1; i --){
    		if(dirsFilter.get(i).equals("..")){
    			doubleP++;
    		}else{
    			break;
    		}
    	}
    	//  a/b/../../.. 统计第一个有名字目录前面..的数量
    	// i 指向的位置就是第一个不是..的字符，doubleP就是..的数量
    	
    	if(i == -1 || doubleP > i){
    		return "/";
    	}
    	List<String> ans = new LinkedList<>();
    	ans.add(dirsFilter.get(i));
    	for( i> -1)
    	
    	
    	
    	return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 // split test
		String path = "ko";
		String []ps = path.split("/");
		System.out.println(ps[0]+"L");
	}

}
