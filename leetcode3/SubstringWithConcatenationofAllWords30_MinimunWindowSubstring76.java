package qiang.leetcode3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 每个单词的长度都相同为size，并且子串必须包含所有的单词，
 * 这样就限制了一些条件，我们一次从s中取出size个字符，然后检查该单词是否是在给定集合中，
 * 如果是，将出现的单词标记为false，继续进行，如果不是，那么窗口向下移动一个，依次判断，
 * 要么集合中的所有单词都出现了，要么窗口移动到s的末端。
 * @author jq
 *
 */
public class SubstringWithConcatenationofAllWords30_MinimunWindowSubstring76 {
	public static  List<Integer> findSubstring(String s, String[] words) { 
		
		List<Integer> ans = new LinkedList<>();
		if(words == null || words.length == 0) return ans;
		int wLen = words[0].length();
		int wN = words.length;
		int N = s.length();
		if(N<wLen * wN) return ans;
		Map<String,Integer> wordsToIndexMap = new HashMap<>(); // 用于将单词和index对应。
		int []needFound = new int[N];
		int index = 0;
		int map;
		for(int i =0;i< wN;i++){
			if(!wordsToIndexMap.containsKey(words[i])){
				wordsToIndexMap.put(words[i],index);
				map = index;
				index++;
			}else{
				map = wordsToIndexMap.get(words[i]);
			}
			needFound[map]++;
		}
		int last = N-wLen+1;
		int [] smapping = new int[last]; // 将S映射到单词
		String tempN;
		for(int j =0;j<last;j++){
			tempN = s.substring(j,j+wLen);
			Integer m = wordsToIndexMap.get(tempN);
			if(m !=null){
				smapping[j] = m;
			}else{
				smapping[j]=-1;
			}
		}
		for(int i = 0;i<wLen;i++){
			int []hasFound = new int[N];
			int begin = i,end = i;
			int m;
			int count = 0;
			while(end<last){
				// 找到一个窗口
				m = smapping[end];
				if(m > -1 ){ // 大于0，说明在words中
					hasFound[m]++;
					if(needFound[m] >= hasFound[m]){
						count++;
					}
					
					if(count == words.length){ // 找到一个窗口，包含所有单词
						while(begin<end){
							int bb = smapping[begin];
							if(bb >-1){
								if(hasFound[smapping[begin]] > needFound[smapping[begin]])
									hasFound[smapping[begin]]--;
								else break;
							}
							begin+=wLen;
						}
//						System.out.println(begin);
						if(end-begin+wLen == wN*wLen){
							ans.add(begin);
						}
					}
					
				}
				end+=wLen;
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String []words={"fooo","barr","wing","ding","wing"};
		String []words={"foo", "bar"};
		System.out.println(findSubstring("barfoothefoobarman",  words));
	}

}
