package qiang.test;


import java.util.ArrayList;
import java.util.LinkedList;

public class TangBo2 {
	class NGramLabel{
		int start;
		int end;
		public NGramLabel(int start,int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	public static ArrayList<String> generateSentence(ArrayList<String> words,ArrayList<NGramLabel> nGramLabels)
	{
		ArrayList<String> result = new ArrayList<>();
		//write your code here
		return result;
	}
	
	void dfs(ArrayList<String> words, int wordIndex,ArrayList<NGramLabel> nGramLabels,int nLabelIndex,
			LinkedList<NGramLabel> partAns,ArrayList<String> result){
		
		if(wordIndex == words.size()){
			result.add(this.oneAns(partAns,words));
			return;
		}
		if(nGramLabels.size() == partAns.size()){
			result.add(this.oneAns(partAns, words));
			return ;
		}
		
		// dfs
		for(int j = nLabelIndex; j < nGramLabels.size();j++){
			
			if(j == 0 ){
				partAns.add(nGramLabels.get(j));
			}else{
				// 找到第一个和前一个没有冲突的label
				
				
				
			}
			
		}
		
		
		
		
		
	}
	String oneAns(LinkedList<NGramLabel> oneAns,ArrayList<String> words){
		StringBuilder sb = new StringBuilder();
		int curIndex = 0;
		for(NGramLabel nl:oneAns){
			if(nl.start < 0)continue;
			if(curIndex < nl.start){
				while(curIndex<words.size() && curIndex < curIndex){
					sb.append(words.get(curIndex++)+" ");
				}
			}else{
				while(curIndex<words.size() && curIndex < nl.end){
					sb.append(words.get(curIndex++)+"-");
				}
				sb.append(words.get(curIndex++)+" ");
			}
		}
		return sb.toString().trim();
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
	}
}














