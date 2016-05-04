package qiang.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MinimunWindowSubstring76{
	
	
	 public static String minWindow(String s, String t) {
	     
		 if(s == null || t == null)  return "";
		 Map<Character,LinkedList<Integer>>  charS   = new HashMap<>();
		 Map<Character,Integer>  allChar = new HashMap<>();
		 int sSize = s.length();
		 int tSize = t.length();
		 // 统计t中的字符出现情况，因为有可能有重复出现的，所以使用map，否则就用set
		 char temp;
		 int coun;
		 for(int i=0; i < tSize; i++){
			 temp = t.charAt(i);
			 if(allChar.containsKey(temp)){
				 allChar.put(temp, allChar.get(temp)+1);
			 }else{
				 allChar.put(temp, 1);
			 }
		 }
		 
		 int minPos = sSize+2;// ,maxMin = 0 
		 int ansMinWinSize = sSize+2;
		 int ansPosX = -1,ansPosY = -1;
		 int countAll = 0;
		 int curSize;
		 LinkedList<Integer> tempIndexList;
		 for(int j =0; j < sSize; j++){
			 temp = s.charAt(j);
			 if(allChar.containsKey(temp)){
				 if(charS.containsKey(temp)){
					 tempIndexList = charS.get(temp);
					 curSize = tempIndexList.size();
					 coun = allChar.get(temp);// 获取数量限制
					 if(curSize < coun){ // 还可以加入到list中
						 tempIndexList.addLast(j);
						 charS.put(temp, tempIndexList);
						 countAll++;
					 }else{// 不能再添加，就只能更新，将list的第一个去掉
						 tempIndexList.removeFirst();
						 tempIndexList.addLast(j);
						 charS.put(temp, tempIndexList);
					 }
					 
				 }else{
					 tempIndexList = new LinkedList<Integer>();
					 tempIndexList.addLast(j);
					 charS.put(temp, tempIndexList);
					 countAll++;
				 }
				 // 已经包含t中的所有字符
				 if(countAll == tSize){
					 minPos = sSize;
					 int k;
					 for(LinkedList<Integer>  tempList:charS.values()){
						 k = tempList.get(0);// 每个字符的最小的index
						 if(k < minPos){
							 minPos = k;
						 }
					 }
				     if( j - minPos+1 < ansMinWinSize){
						ansMinWinSize = j - minPos +1;
						ansPosX = minPos;
						ansPosY = j;
					}
				 }
			 }
			 
		 }
		 if(ansPosX == -1) return "";
		 return s.substring(ansPosX, ansPosY+1);
    }
	
	
	
	/**
	 *  当期这种方法没有考虑t中有重复字符出现的情况
	 * @param s
	 * @param t
	 * @return
	 */
	 public static String minWindow2(String s, String t) {
	     
		 if(s == null || t == null)  return "";
		 Map<Character,Integer>  charS   = new HashMap<>();
		 Set<Character>  allChar = new HashSet<>();
		 int sSize = s.length();
		 int tSize = t.length();
	
		 
		 // 统计t中的字符出现情况，因为有可能有重复出现的，所以使用map，否则就用set
		 char temp;
		 for(int i=0; i < tSize; i++){
			 allChar.add(t.charAt(i));
		 }
		 
		 int minPos = sSize+2;// ,maxMin = 0 
		 int ansMinWinSize = sSize+2;
		 int ansPosX = -1,ansPosY = -1;
		 for(int j =0; j < sSize; j++){
			 temp = s.charAt(j);
			 if(allChar.contains(temp)){
				charS.put(temp, j);
				if(charS.size() == tSize){
					minPos = sSize;
					for(int k:charS.values()){
						if( k < minPos ){
							minPos = k;
						}
					}
					if( j - minPos+1 < ansMinWinSize){
						ansMinWinSize = j - minPos +1;
						ansPosX = minPos;
						ansPosY = j;
					}
				}
			 }
			 
		 }
		 if(ansPosX == -1) return "";
		 return s.substring(ansPosX, ansPosY+1);
    }

	public static  void main(String[]args) {
		// TODO Auto-generated method stub
		
		System.out.println(minWindow("ababaa", "aba"));
	}
}