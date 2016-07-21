package qiang.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder127_4 {


	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		
		if(wordList == null) return 0;
		LinkedList<String> queue = new LinkedList<String>();
		int cur=0,last =1;
		queue.addLast(beginWord);
		int ans =1;
		char [] chars;
		while(queue.isEmpty()==false){
			String top = queue.getFirst();
			queue.removeFirst();
			last--;
			chars = top.toCharArray();
			for(int i = 0 ; i < chars.length; i++){
				char c = chars[i];
				for(char j ='a';j<='z';j++){
					if(j == c) continue;
					chars[i] = j;
					String curStr = new String(chars);
					if(curStr.equals(endWord)) return ans+1;
					if(wordList.contains(curStr)){
						queue.addLast(curStr);
						wordList.remove(curStr);
						cur++;
					}
				}
				chars[i] = c; // 还原
			}
			if(last == 0){
				last = cur;
				cur = 0;
				ans++;
			}
		}
		
		return 0;
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String []wl = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		String []wl = {"hot","dot","dog","lot","log"};
		HashSet<String> wordDict = new HashSet<>();
		for(String a:wl){
			wordDict.add(a);
		}
		System.out.println(new WordLadder127_4().ladderLength("hit", "cog", wordDict));
	}

}
