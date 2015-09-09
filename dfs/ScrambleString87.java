package qiang.dfs;

import java.util.HashMap;

public class ScrambleString87 {

	
	
    public boolean isScramble(String s1, String s2) {
        
    	if(s1 == null && s2 == null) return true;
    	if(s1 == null )  return false;
    	if(s2 == null )return false;
    	int size1 = s1.length();
    	int size2 = s2.length();
    	if(size1 != size2 ) return false;
    	short partSameFlag[][][]= new short[size1][size1][size1+1];
    	
    	return scramble(partSameFlag,s1, 0, s1.length()-1, s2, 0, s2.length()-1);
    }	
	
    HashMap<Character, Integer> partSameMap = new HashMap<>();
	boolean scramble(short [][][] partSameFlag,String s1,int b1,int e1,String s2,int b2,int e2){

//			// 递归出口,其实这个条件不需要判断，因为肯定是相等的。
//			if (e1-b1 != e2 - b2) {
//				return false;
//			}
			if(e1-b1 == 0 ){
				return s1.charAt(b1)==s2.charAt(b2);
			}
			if(partSameFlag[b1][b2][e1-b1+1] == 0){
				partSameMap.clear();
				for(int i=b1; i< e1+1; i++){
					if(partSameMap.containsKey(s1.charAt(i))){
						partSameMap.put(s1.charAt(i), partSameMap.get(s1.charAt(i))+1);
					}else{
						partSameMap.put(s1.charAt(i), 1);
					}
				}
				int j=b2,k;
				for( j = b2; j <e2+1; j++){
					if(partSameMap.containsKey(s2.charAt(j))){
						k = partSameMap.get(s2.charAt(j));
						k--;
						if(k<0) {
							partSameFlag[b1][b2][e1-b1+1]= -1 ;
							break;
						}
						partSameMap.put(s2.charAt(j), k);
					}else {
						partSameFlag[b1][b2][e1-b1+1]= -1 ;
						break;
					}
				}
				if(j==e2+1){ // 相同的字符。
					partSameFlag[b1][b2][e1-b1+1]= 1 ;
				}
			}
			if(partSameFlag[b1][b2][e1-b1+1] < 0) return false;
		
			boolean left=false,right = false;
			for(int i = 0; i<e1-b1; i++){
				left = scramble(partSameFlag, s1, b1, b1+i, s2, b2,b2+ i);
				right = scramble(partSameFlag, s1, b1+i+1, e1, s2,b2+ i+1, e2);
				if(left && right) return true;
					left = scramble(partSameFlag, s1, b1, b1+i, s2, e2-i, e2);
					right = scramble(partSameFlag, s1, b1+i+1, e1, s2, b2, e2-i-1);
				if( left && right)return true;
			}
			return false;	
	}
    
	public static void main(String[] args) {

		ScrambleString87 ss = new ScrambleString87();
		System.out.println(ss.isScramble("rgeat", "grect"));
	}

}
