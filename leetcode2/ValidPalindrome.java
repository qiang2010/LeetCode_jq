package qiang.leetcode2;

public class ValidPalindrome {

	
	public boolean isPalindrome(String s) {
	      boolean ans = true;
	      if("".equals(s) || s == null) return ans;
	      int size = s.length();
	      int left =0,right = size-1; 
		  s = s.toLowerCase();
	      while(left < right){
	    	  while(left < size && !(('a' <= s.charAt(left) && s.charAt(left)<= 'z')||(s.charAt(left)>='0'&&s.charAt(left)<='9'))){
	    		  left++;
	    	  }
	    	  if(left == size) return ans;
	    	  while(right > -1 && !(('a' <= s.charAt(right) && s.charAt(right)<= 'z')||(s.charAt(right)>='0'&&s.charAt(right)<='9'))){
	    		  right--;
	    	  }
	    	  if(right == -1 ) return ans;
	    	  
	    	  if(s.charAt(left) != s.charAt(right)){
	    		  return false;
	    	  }
	    	  left++;right--;
	      }
	     return ans;  
	}	
	
	public static void main(String[] args) {

		System.out.println(new ValidPalindrome().isPalindrome("a."));
		
		
	}

}
