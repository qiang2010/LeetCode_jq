package qiang.test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TangBo {
	
	static class NGramLabel{
		int start;
		int end;
//		int id;
		public NGramLabel(int start,int end)
		{
			this.start = start;
			this.end = end;
//			this.id = id;
		}
//		public boolean equals(NGramLabel one){
////			return this.id == one.id;
//		}
//		public int hashCode(){
//			return this.id;
//		}
	}
	public static void main(String[] args) {
		/* 
		 1. What we have done.
		 We have split a sentence to ArrayList, including punctuation, and also label all words that need merge.
		 2. What we need do.
		 Now, we need generate all possible combinations of sentence which contain maximum labeled words.
		 
		 For example:
		 sentence: show me all luxury car in United States of America.
		 
		 First, We will split the sentence to ArrayList, and it contain 11 words. That is 'show', 'me', 'all', 'luxury', 'car', 'in', 'United', 'States', 'of', 'America' and '.'
		 It was obvious that 'United States of America' should be treated as whole, so we will labeled the words by one NGramLabel's object. new NGramLabel(6,9);
		 However, a sentence would contain many blocks, so we need a ArrayList save all blocks.
		 
		 Then we need generate all possible combinations of sentence according the blocks.
         The above example, We need to get the following result:
         show me all luxury car in United-States-of-America.
         
         Complex example:
         Sentence: X X X X X X X X X.
         ArrayList<NGramLabel> nGramLabels = new ArrayList<NGramLabel>();
         nGramLabels.add(new NGramLabel(1,3));
         nGramLabels.add(new NGramLabel(2,4));
         nGramLabels.add(new NGramLabel(7,8));
         
         result:
         X X-X-X X X X X-X.
         X X X-X-X X X X-X.
         
         Now, How to write this algorithm? 
         You can write your code on generateSentence function.
		*/
		ArrayList<NGramLabel> nGramLabels = new ArrayList<NGramLabel>();
        nGramLabels.add(new NGramLabel(0,2));
        nGramLabels.add(new NGramLabel(1,3));
        nGramLabels.add(new NGramLabel(2,7));
        nGramLabels.add(new NGramLabel(6,8));
        nGramLabels.add(new NGramLabel(10,11));
        nGramLabels.add(new NGramLabel(0,10));
        ArrayList<String> words = new ArrayList<>();
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        words.add("X");
        TangBo tt = new TangBo();
        
        ArrayList<String> res = tt.generateSentence(words, nGramLabels);
        for(String s:res)System.out.println(s);
	}
	boolean [][]allConPare;// 记录每对是否冲突
	public    ArrayList<String> generateSentence(ArrayList<String> words,ArrayList<NGramLabel> nGramLabels)
	{
		ArrayList<String> result = new ArrayList<>();
		
		// 按照 起始排序
		Comparator<NGramLabel> com = new Comparator<TangBo.NGramLabel>() {
			@Override
			public int compare(NGramLabel o1, NGramLabel o2) {
				if(o1.start != o2.start)return Integer.compare(o1.start, o2.start);
				return Integer.compare(o1.end, o2.end);
			}
		};
		nGramLabels.sort(com);
		// 构建冲突集合
		// 所有的冲突对。
		int nSize = nGramLabels.size();
		allConPare = new boolean [nSize][nSize];
		NGramLabel cur;
		for(int i = 0 ; i <nSize;i++ ){
			cur = nGramLabels.get(i);
			for(int j = i+1;j < nSize;j++){
				boolean con = this.isConfic(cur, nGramLabels.get(j));
				allConPare[i][j] =allConPare[j][i] =con;  
			}
		}
//		Map<Integer,Set<NGramLabel>> confilctAll = new HashMap<>();
		List<LinkedList<NGramLabel>> confic = new ArrayList<LinkedList<NGramLabel>>();
		
		NGramLabel next;
		for(int i = 0 ; i < nSize;){
			LinkedList<NGramLabel> tempConfic = new LinkedList<>();
			cur = nGramLabels.get(i);
			tempConfic.add(cur);
			// 向右找冲突集合
			int left= i-1;int  right = i+1;
			while(right <nSize){
				next = nGramLabels.get(right);
				if(isConfic(cur,next)){
					tempConfic.add(next);
					right++;
				}else{
					break;
				}
			}
			// 向左找冲突集合
			while(left > -1){
				next = nGramLabels.get(left);
				if(isConfic(cur,next)){
					tempConfic.add(next);
					left--;
				}else{
					break;
				}
			}
			Set<Integer> noconf = this.getUnConf(tempConfic);
			i= right;
			for(int noc : noconf){
				confic.add(this.getConficForGiven(noc, nGramLabels));
			}
//			i++;
			confic.add(tempConfic);
		}
		for(List<NGramLabel> curs : confic){
			for(NGramLabel a:curs){
				System.out.print(a.start+":"+a.end+"\t");
			}
			System.out.println();
		}
		System.out.println("depart");
		dfs(words, confic, 0, new LinkedList<NGramLabel>(), result);
		return result;
	}
	
	
	
	LinkedList<NGramLabel> getConficForGiven(int i,ArrayList<NGramLabel> nGramLabels){
		LinkedList<NGramLabel> tempConfic = new LinkedList<>();
		NGramLabel next;
		NGramLabel cur = nGramLabels.get(i);
		tempConfic.add(cur);
		// 向右找冲突集合
		int nSize =  nGramLabels.size();
		int left= i-1;int  right = i+1;
		while(right <nSize){
			next = nGramLabels.get(right);
			if(isConfic(cur,next)){
				tempConfic.add(next);
				right++;
			}else{
				break;
			}
		}
		// 向左找冲突集合
		while(left > -1){
			next = nGramLabels.get(left);
			if(isConfic(cur,next)){
				tempConfic.add(next);
				left--;
			}else{
				break;
			}
		}
		return tempConfic;
	}
	// 获取冲突集合中，可能不冲突的interval
	Set<Integer> getUnConf(LinkedList<NGramLabel> tempConfic){
		int nSize = tempConfic.size();
		Set<Integer> ans = new HashSet<>();
		NGramLabel cur;
		for(int i = 0 ; i <nSize;i++ ){
				cur = tempConfic.get(i);
				for(int j = i+1;j < nSize;j++){
					boolean con = this.isConfic(cur, tempConfic.get(j));
					if(!con){
						ans.add(i);
						ans.add(j);
					}
				}
		}
		return ans;
	}
	
	// 输入保证 one的起始位置小于tow的其实位置
	public   boolean isConfic(NGramLabel one,NGramLabel two){
		if(one.start == two.start) return true;
		if(one.start > two.start){
			return one.start < two.end;
		}
		return two.start< one.end;
	}
	 void dfs(ArrayList<String> words,List<LinkedList<NGramLabel>> confic,int conficIndex,
			LinkedList<NGramLabel> partAns,ArrayList<String> result){
		if(confic.size() == conficIndex){
			String one = oneAns(partAns, words);
			for(NGramLabel a:partAns){
				System.out.print(a.start+":"+a.end+"\t");
			}
			System.out.println();
			result.add(one);
			return ;
		}
		// dfs 获取当前confic集合
		LinkedList<NGramLabel> curCon = confic.get(conficIndex);
		boolean conF = false;
		for(NGramLabel c : curCon){
			// 如果 当前c 和之前的冲突，跳过,否则加入到解中
			conF = false;
			if(isConfWithBefore(partAns,c)) conF = true;
			if(!conF)partAns.add(c);
			dfs(words, confic, conficIndex+1, partAns, result);
			if(!conF)partAns.removeLast();
		}
	}
	 boolean isConfWithBefore(LinkedList<NGramLabel> partAns,NGramLabel cur){
		 if(partAns.size() == 0) return false;
		for(NGramLabel one : partAns){
			if(isConfic(one, cur)){
				return true;
			}
		}
		return false;
	}
	 String oneAns(LinkedList<NGramLabel> oneAns,ArrayList<String> words){
		StringBuilder sb = new StringBuilder();
		int curIndex = 0;
		
		for(int i= 0;i < oneAns.size();i++){
			NGramLabel nl = oneAns.get(i);
			if(curIndex < nl.start){
				while(curIndex<words.size() && curIndex < nl.start){
					sb.append(words.get(curIndex++)+" ");
				}
				while(curIndex < words.size() && curIndex<nl.end){
					sb.append(words.get(curIndex++)+"-");
				}
				sb.append(words.get(curIndex++)+" ");
			}else{
				// 处理 0-2 2-7 这种情况
				if(curIndex > nl.start){
					sb.deleteCharAt(sb.length()-1);
					sb.append("-");
				}
				while(curIndex<words.size() && curIndex < nl.end){
					sb.append(words.get(curIndex++)+"-");
				}
				sb.append(words.get(curIndex++)+" ");	
				
			}
		}
		while(curIndex < words.size()){
			sb.append(words.get(curIndex++)+" ");
		}
		return sb.toString().trim();
	}
}
