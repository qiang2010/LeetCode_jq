package qiang.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralizedAbbreviation320 {

	public static void main(String[] args) {
		GeneralizedAbbreviation320 dd = new GeneralizedAbbreviation320();
		
		System.out.println(dd.generateAbbreviations2("word"));
	}
	public List<String> generateAbbreviations(String word) {
		
		List<String> ans = new LinkedList<>();
		if(word == null || word.length() == 0) return ans;
		dfs(word.toCharArray(),0,ans);
		return ans;
	}
	void dfs(char []array,int index,List<String> ans){
		
		ans.add(merge(array));
		
		for(int i =index; i < array.length;i++){
			
			char c = array[i];
			array[i]= '1';
			dfs(array,i+1,ans);
			array[i] = c;
		}
	}
	String merge(char []array){
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<array.length;){
			
			int  count = 0;
			while(i< array.length && array[i] =='1' ){
				count++;i++;
			}
			if(count == 0)sb.append(array[i++]);
			else sb.append(count);
		}
		return sb.toString();
	}
	public List<String> generateAbbreviations2(String word) {
	    List<String> res = new ArrayList<String>();
	    if (word.length() == 0) {
	        res.add(word);
	        return res;
	    }
	    char[] c = word.toCharArray();
	    char[] aux = new char[word.length()]; //auxiliary array for generating abbreviation
	    generateAbbreviations(aux, 0, c, 0, res);
	    return res;  
	}
	private void generateAbbreviations(char[] aux, int p1, char[] c, int p2, List<String> res){
	    // not abbr
	    aux[p1] = c[p2];
	    if (p2 == c.length - 1) res.add(new String(aux, 0, p1 + 1));
	    else generateAbbreviations(aux, p1 + 1, c, p2 + 1, res);
	    // abbr
	    for (int i = 1; i <= c.length - p2; i++){
	        int l = i;//length of abbreviation
	        int p = p1;
	        while(l >= 10){
	            aux[p++] = (char)(l / 10 + '0');
	            l = l - l / 10 * 10; 
	        }
	        aux[p++] = (char)(l + '0');
	        if (p2 + i == c.length) res.add(new String(aux, 0, p)); // abbr all the remaining
	        else if (p2 + i == c.length - 1) { // abbr all the remaining except the last character
	            aux[p++] = c[p2 + i];// the following character cannot be abbreviated
	            res.add(new String(aux, 0, p));
	        }
	        else {
	            aux[p++] = c[p2 + i];// the following character cannot be abbreviated
	            generateAbbreviations(aux, p, c, p2 + i + 1, res);
	        }
	    }
	}
}
