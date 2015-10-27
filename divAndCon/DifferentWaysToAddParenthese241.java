package qiang.divAndCon;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthese241 {

	public static void main(String[] args) {
		
		List<Integer> ans = new DifferentWaysToAddParenthese241().diffWaysToCompute("1245");
		for(int a:ans){
			System.out.println(a);
		}
	}

	
	public List<Integer> diffWaysToCompute(String input) {
        
		return div(input, 0, input.length()-1);
		
	}
	public List<Integer> div(String input,int b,int e){
		
		if(b == e){
			List<Integer> ans = new ArrayList<Integer>();
			ans.add(input.charAt(b)-'0');
			return ans;
		}
		int jj;
		for( jj = b; jj <=e;jj++){
			if(input.charAt(jj) < '0' || input.charAt(jj) > '9')break;
		}
		if(jj ==e+1){
			List<Integer> ans = new ArrayList<Integer>();
			ans.add(Integer.parseInt(input.substring(b, e+1)));
			return ans;
		}
		List<Integer> ansAll = new ArrayList<Integer>();
		for(int i=b; i<=e;i++){
			char c = input.charAt(i);
			if(c =='*'  || c =='-'  || c =='+'  ){
				List<Integer> left = div(input, b, i-1);
				List<Integer> right = div(input, i+1, e);
				List<Integer> lst = new ArrayList<>();
				switch (c) {
				case '+':
					for(int j=0;j<left.size();j++){
						for(int k =0;k<right.size();k++){
							lst.add(left.get(j)+right.get(k));
						}
					}
					
					break;

				case '-':
					for(int j=0;j<left.size();j++){
						for(int k =0;k<right.size();k++){
							lst.add(left.get(j)-right.get(k));
						}
					}
					break;
				case '*':
					for(int j=0;j<left.size();j++){
						for(int k =0;k<right.size();k++){
							lst.add(left.get(j)*right.get(k));
						}
					}
					break;	
	
				default:
					break;
				}
				ansAll.addAll(lst);
			}
			
		}
		return ansAll;
	}
	
}
