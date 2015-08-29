package qiang.leetcode;

import java.util.LinkedList;
import java.util.List;

public class TextJustification68 {

	
    public static List<String> fullJustify(String[] words, int maxWidth) {
    
    	List<String> ans = new LinkedList<String>();
    	if(words == null || words.length == 0 ) return ans; 
    	int wordsNum = words.length;
    	StringBuilder temS= new StringBuilder();
    	if(wordsNum == 1){
    		
    		temS.append(words[0]);
    		if(maxWidth > words[0].length() ){
    			ans.add(temS.append(spaceGene(maxWidth-words[0].length())).toString());
    		}else
    			ans.add(temS.toString());
    		return ans;
    	}
    	int sumLen =0;
    	List<String> tempLine ;
    	List<List<String>> partClub = new LinkedList<List<String>>();
    	List<Integer> partSize = new LinkedList<Integer>();
    	for(int i = 0 ; i < wordsNum; ){
    		sumLen = 0;
    		tempLine = new LinkedList<String>();
    		while(i < wordsNum && (sumLen+words[i].length()) < maxWidth+1 ){
    			tempLine.add(words[i]);
    			
    			sumLen += words[i].length()+1;
    			i++;
    		}
    		partClub.add(tempLine);
    		partSize.add(sumLen-tempLine.size());
    	}
    	int partNum = partClub.size();
    	// 先不处理最后的两个。
    	int num;
    	StringBuilder sb ;
    	int spaceSize = 0;
    	StringBuilder space;
    	
    	// 假设本身就只有一组。
    	if(partNum == 1){
    		tempLine = partClub.get(0);
    		spaceSize = maxWidth - partSize.get(0);
    		sb = new StringBuilder();
    		for(int k = 0 ; k < tempLine.size(); k++ ){
    			sb.append(tempLine.get(k));
    		}
    		sb.append(spaceGene(spaceSize));
    		ans.add(sb.toString());
    		return ans;
    	}
    	
    	
    	int i =0 ; 
    	for(i = 0 ; i < partNum-1;i++){
    		tempLine = partClub.get(i);	 // 获取一个组的单词
     		sumLen =  partSize.get(i);	 // 获取所有单词的长度之和
    		num = tempLine.size(); 		  //单词的数量
    		sb = oneLineGene(tempLine, sumLen, maxWidth, num);
    		ans.add(sb.toString());
    	}
    	
    	tempLine = partClub.get(i);
    	sumLen = partSize.get(i);
    	num = tempLine.size();
    	sb = new StringBuilder();
    	int j=0;
    	for( j = 0; j<num-1; j++ ){
    		sb.append(tempLine.get(j));
    		sb.append(" ");
    	}
    	//if (num>1) {
		sb.append(tempLine.get(j));
		//}
    	sb.append(spaceGene(maxWidth-sumLen-j));
    	ans.add(sb.toString());
    	//int last2() 
    	
    	return ans;
    }
    
   static StringBuilder oneLineGene(List<String> tempLine,int sumLen,int maxWidth,int num){
    	StringBuilder sb = new StringBuilder();
    	StringBuilder space = new StringBuilder();
    	int spaceSize =0;
    	if(num > 1){
			spaceSize = (maxWidth-sumLen)/(num-1);
		}else{
			spaceSize = maxWidth-sumLen; // 一行一个单词
		}
		space = spaceGene(spaceSize);
		sb.append(tempLine.get(0));
		sb.append(space);
		int leftSpace =0;
		if(num > 1 && (maxWidth-sumLen)%(num-1)!=0){
			leftSpace =(maxWidth-sumLen)%(num-1);
			sb.append(" "); // 给第一个单词多加一个空格。
		}
		int j=1;
		for( j =1; j < num-1; j++){
			sb.append(tempLine.get(j));
			sb.append(space);
			if(j<leftSpace){
				sb.append(" ");
			}
		}
		if(num>1) // 说明至少有两个单词
			sb.append(tempLine.get(num-1));
		return sb;
    }
    
    public static StringBuilder spaceGene(int n){
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i < n; i++){
    		sb.append(" ");
    	}
    	return sb;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String words[] ={"This", "is", "an", "example", "of", "text", "justification."};
		String words[] ={"What","must","be","shall","be."};
		List<String> ans = fullJustify(words, 12);
		for(int j = 0 ; j < ans.size(); j++){
			System.out.println(ans.get(j));
		}
	}

}
