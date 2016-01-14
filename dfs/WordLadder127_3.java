package qiang.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder127_3 {


	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		
		if(wordList == null) return 0;
		LinkedList<String> queue = new LinkedList<String>();
		LinkedList<Integer> queueLevel = new LinkedList<>();
		wordList.add(endWord);
		Set<String> visited = new HashSet<>();
		queue.addLast(beginWord);
		queueLevel.addLast(0);
		visited.add(beginWord);
		int i=0;
		String top;
		char []wordCharArray;
		char c;
		String newWord;
		while(!queue.isEmpty()){
			top = queue.getFirst();
			queue.removeFirst();
			i = queueLevel.getFirst();
			queueLevel.removeFirst();
			if(top.equals(endWord)) return i+1;
			wordCharArray = top.toCharArray();
			for(int j =0 ; j < wordCharArray.length;j++){
				c = wordCharArray[j];
				for(char a = 'a'; a <= 'z'; a++){
					wordCharArray[j] = a;
					newWord = new String(wordCharArray);
					if(!wordList.contains(newWord))continue;
					if(visited.contains(newWord))continue;
					queue.addLast(newWord);
					visited.add(newWord);
					queueLevel.addLast(i+1);
				}
				wordCharArray[j] = c;
			}
//			for(String w:wordDict){
//				if(!visited.contains(w) && isDistanceIsOne(w, top)){
//					queue.addLast(w);
//					queueLevel.addLast(i+1);
//					visited.add(w);
//				}
//			}
		}
		return 0;
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []wl = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		
		HashSet<String> wordDict = new HashSet<>();
		for(String a:wl){
			wordDict.add(a);
		}
		System.out.println(new WordLadder127_3().ladderLength("qa", "sq", wordDict));
	}

}
