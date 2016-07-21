package qiang.leetcode6;

public class OneEditDistance161 {

	 public static void main(String[] args) {
		
		 OneEditDistance161 one = new OneEditDistance161();
		 System.out.println(one.isOneEditDistance("aaaaaa", "aaaaaab"));
	}
	
	public boolean isOneEditDistance(String s, String t) {  
		 
		if(s == null || t == null) return true;
		
		int s1 = s.length();
		int s2 = t.length();
		if(s1==s2){
			int count =0;
			for(int i=0;i<s1;i++){
				if(s.charAt(i)!=t.charAt(i))count++;
				if(count >1) return false;
			}
			return count==1;
		}
		if(s1 ==s2+1){
			return this.deleteOne(s, t, s2);
		}else{
			if(s1+1 == s2){
				return this.deleteOne(t, s, s1);
			}
		}
		return false;
	}
	/**
	 * 保证前面的那个长一些
	 * @param s
	 * @param t
	 * @return
	 */
	boolean deleteOne(String s,String t,int shortS){
		int count = 0;
		int i =0,j=0;
		while(i<shortS+1 && j < shortS ){
			if(s.charAt(i)!=t.charAt(j)){
				i++;
				count++;
				if(count >1) return false;
			}else{
				i++;j++;
			}
		}
		return true;
	}
}
