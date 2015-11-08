package qiang.breakthroughOfOffer;

import java.util.Arrays;

public class ReverseWords42 {

	public static void main(String[] args) {
		String wordsString = "I am a student.";
		char []words=wordsString.toCharArray();
		reverseWords(words);
	}
	
	static void reverseWords(char words[]){
		
		reverseOneWord(words, 0, words.length-1);
		int i =0;
		int size = words.length;
		while( i < size){
			while(i<size && words[i]==' ')i++;
			int j = i+1;
			while(j < size && words[j]!=' ')j++;
			reverseOneWord(words, i, j-1);
			i = j;
		}
		System.out.println(Arrays.toString(words));
	}
	static void reverseOneWord(char []words,int begin,int end){
		
		if(begin < 0 || begin > words.length-1 || end < 0 ||end > words.length-1)return;
		char a;
		for(int i = begin,j = end; i<j;i++,j--){
			a = words[i];
			words[i] = words[j];
			words[j]= a;
		}
	}
	
}
