package qiang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 每个单词的长度都相同为size，并且子串必须包含所有的单词，
 * 这样就限制了一些条件，我们一次从s中取出size个字符，然后检查该单词是否是在给定集合中，
 * 如果是，将出现的单词标记为false，继续进行，如果不是，那么窗口向下移动一个，依次判断，
 * 要么集合中的所有单词都出现了，要么窗口移动到s的末端。
 * @author jq
 *
 */
public class SubstringWithConcatenationofAllWords30 {
 
	
	public static  List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<Integer>();
		if(s==null || "".equals(s))return ans;
		if(words ==  null || words.length==0) return ans;
		int nums = words.length;
		int wordSize = words[0].length();
		int windowSize = nums*wordSize;
		int size = s.length();
		int end = size -windowSize +1;
		String tempWord;
		HashMap<String,Integer> wordsMap = new HashMap<>();
		HashMap<String,Integer> curMap = new HashMap<>();
		
		for(int j = 0 ; j < nums;j++){
			if(wordsMap.containsKey(words[j])){
				wordsMap.put(words[j], wordsMap.get(words[j])+1);
			}else wordsMap.put(words[j], 1);
		}
		//curMap = wordsMap.clone();
		int curWordsNum = 0;
		int cur;
		for(int i = 0 ; i < end; ){
			 cur = i;
			while(cur<size-wordSize+1){
				tempWord = s.substring(cur, cur+wordSize);
				if(wordsMap.containsKey(tempWord)){
					curWordsNum++; //  这里记录出现过的单词数量，就是为了当窗口已经达到 windowSize的时候，判断curMap和wordsMap是否相同
					if(curMap.containsKey(tempWord)){
						int n1 = curMap.get(tempWord)+1;
						int n2 = wordsMap.get(tempWord);
						// i++ 重新开始判断，窗口归零。
						if(n1 > n2){
							i++;
							curMap.clear();
							curWordsNum = 0;
							break;
						}
						// 如果 n1==n2 ,并且 wordsMap 和大小 和 curMap的大小相同。
						if(n1==n2){
							if( curWordsNum == nums){
								ans.add(i);
							    System.out.println(i);
								curMap.clear();
								curWordsNum=0;
								i++;break;
							}
						}else{
							if(curWordsNum > nums){
								i++;
								curMap.clear();
								curWordsNum =0;
								break;
							}
						}
						cur = cur + wordSize;
						curMap.put(tempWord, n1);
					}else{
						if( curWordsNum == nums){
							ans.add(i);
							System.out.println(i);
							curMap.clear();
							curWordsNum=0;
							i++;break;
						}else{
							if(curWordsNum > nums){
								i++;
								curMap.clear();
								curWordsNum =0;
								break;
							}
						}
						curMap.put(tempWord, 1);
						cur = cur + wordSize;
					}
				}else{
					curMap.clear();// 这个地方忘记清空了
					curWordsNum=0;
					i++;
					break;
				}
			}
			
		}
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String []words={"fooo","barr","wing","ding","wing"};
		findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",  words);
	}

}
