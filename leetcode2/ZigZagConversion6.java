package qiang.leetcode2;

public class ZigZagConversion6 {

	
	
    public static String convert(String s, int numRows) {
     
    	
    	StringBuilder res = new StringBuilder();
    	if(numRows == 1) return s;
    	if("".equals(s)) return  "";
    	int size = s.length();
    	if(size == 1) return s;
    	int row = numRows > size? size: numRows;  //开始的时候也忽略了 行数numRows和size的大小关系
    	for( int i = 0 ; i< row ; i++){
    		res.append(s.charAt(i));
    		if(i == 0 || i == numRows-1){
    			for( int j = i+2*numRows-2 ; j < size; j+=2*numRows-2){
    				if(j>=size)break;
    				res.append(s.charAt(j));
    			}
    		}else{
    			for( int j = i ; j+2*numRows-2 - 2*i < size; ){
    				j = j+2*numRows-2 - 2*i ;
    				if(j>=size) break;
    				res.append(s.charAt(j));
    				if(j+2*i  >= size ) break;  // 这里开始 我竟然是 使用了> 而忽略了等号的情况。
    				res.append(s.charAt(j+2*i));
    				j= j+2*i;
    			}
    		}
    	}
    	return res.toString();
    }
	
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int row = 2;
		s = "ABC";
		row = 2;
		System.out.println(convert(s,row));
	}

}
