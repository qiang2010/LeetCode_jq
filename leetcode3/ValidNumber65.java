package qiang.leetcode3;

public class ValidNumber65 {

    
	
	
	 public boolean isNumber(String s) {
	        
	        if(s == null || "".equals(s))return true;
	        s = s.trim();
	        boolean numberseen = false;
	        boolean eseen = false;
	        boolean pointseen= false;
	        char c;
	        for(int i =0;i< s.length();i++ ){
	              c = s.charAt(i);
	              // 如果是数字，标记出现过数字
	              if(c <= '9' && c >='0'){
	                  numberseen = true;
	              }else if(c == '.'){ // 如果是点，那么要求前面不能有e，不能有点
	                  if(pointseen|| eseen) return false;
	                  pointseen = true;
	              }else if(c == '+' || c == '-'){// 如果遇到了加减，如果加减前面就是数字或者点，就返回false
	                  if(pointseen || numberseen ) return false;
	              }else if(c == 'e'){
	            	  // 如果遇到了e，那么要清空符号标记，因为e后面可以有一个符号，同时要把数字清空，点也得清空
	                  if(eseen || !numberseen) return false; 
	                  eseen = true;
	                  numberseen =false;
	                  pointseen = false;
	              }else return false;
	        }
	        return numberseen;
	    }
	

}
