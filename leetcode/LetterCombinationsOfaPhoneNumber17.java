package qiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber17 {
 
	
	public static  List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if(digits == null || "".equals(digits))return output;
		String []allNums ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
		int size = digits.length();
		int []flags = new int[size];
		int []currentFlags = new int[size];
		int []pos = new int[size];
		for(int i =0;i< size; i++){
			pos[i] = digits.charAt(i)-'0';
			flags[i] = currentFlags[i] = allNums[pos[i]].length();
		}
		int  curK = size-1;
		StringBuilder tempCom ;
		while( currentFlags[curK] != 0){
			tempCom = new StringBuilder();
			for(int i = 0 ; i < size; i++){
				tempCom.append(allNums[pos[i]].charAt(currentFlags[i]-1));
			}
			//System.out.println(tempCom);
			output.add(tempCom.toString());
			currentFlags[curK]--;
			
			
			while(curK > 0 && currentFlags[curK] == 0){
				currentFlags[curK-1]--;  // 给前面借一个
				currentFlags[curK] = flags[curK];
				curK--;
			}
			if(curK == 0 && currentFlags[curK] == 0) return output;
			curK = size-1;
		}
		
		return output;
    }
	
	
    public List<String> letterCombinations2(String digits) {
        List<String> output = new ArrayList<String>();
        if(digits == null || "".equals(digits))return output;
		String []allNums ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
		int size = digits.length();
		int []flags = new int[size];
		int []currentFlags = new int[size];
		int []pos = new int[size];
		for(int i =0;i< size; i++){
			pos[i] = digits.charAt(i)-'0';
			flags[i] = currentFlags[i] = allNums[pos[i]].length();
		}
		int curK = size-1;
		StringBuilder tempCom ;
		while(true){
			tempCom = new StringBuilder();
			for(int i = 0 ; i < size; i++){
				tempCom.append(allNums[pos[i]].charAt(currentFlags[i]-1));
			}
		//	System.out.println(tempCom);
			output.add(tempCom.toString());
			currentFlags[curK]--;
 
			while(curK > 0 && currentFlags[curK] == 0){
				currentFlags[curK] = flags[curK];
				currentFlags[--curK]--;  // 给前面借一个
			}
			if( currentFlags[0] == 0) return output;
			curK = size-1;
		}
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsOfaPhoneNumber17.letterCombinations("237");
	}

}
