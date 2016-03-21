package qiang.leetcode2;

public class MaximumProductofWordLengths318 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumProductofWordLengths318 mx = new MaximumProductofWordLengths318();
		String []words ={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(mx.maxProduct(words));
	}
	
	   
	public int maxProduct(String[] words) {
	    
		if(words == null || words.length < 2)return 0;
		int maxAns = -1;
		boolean [][]count = new boolean[words.length][26];
		int c = 0;
		for(String w:words){
			for(int j =0;j<w.length();j++){
				count[c][w.charAt(j)-'a'] =true;  
			}
			c++;
		}
		int tempMu;
		for(int i = 0; i< words.length;i++){
			for(int j = i+1;j < words.length;j++){
				if(isTwoWrodsDonotShare(count[i], count[j])){
					tempMu = words[i].length() * words[j].length();
					maxAns = maxAns > tempMu? maxAns:tempMu;
				}
			}
		}
		return maxAns > 0? maxAns:0;
	}	
	boolean isTwoWrodsDonotShare(boolean []w1,boolean []w2){
		for(int i = 0 ; i < 26;i++){
			if(w1[i]&&w2[i])return false;
		}
		return true;
	}

	
	/**
	 * 使用bitmap
	 * @param words
	 * @return
	 */
	public int maxProduct2(String[] words) {
	    
		if(words == null || words.length < 2)return 0;
		int maxAns = -1;
		int []bitmap = new int[words.length];
		int i =0;
		for(String w:words){
			for(int j =0;j<w.length();j++){
				bitmap[i] |= (1<<(w.charAt(j)-'a'));
			}
			i++;
		}
		for(i =0;i<words.length;i++){
			for(int j=i+1;j<words.length;j++){
				if((bitmap[i] &bitmap[j]) ==0){
					int c = words[i].length()*words[j].length();
					maxAns = maxAns > c ? maxAns:c;
				}
				
			}
		}
		return maxAns > 0? maxAns:0;
	}	
}
