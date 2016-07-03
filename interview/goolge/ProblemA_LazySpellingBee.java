package qiang.interview.goolge;

import java.util.HashSet;
import java.util.Set;

import qiang.util.FileUtil;

public class ProblemA_LazySpellingBee {

	public static void main(String[] args) {
		String path = "E:\\googlejam\\";
		int aNun = 3;
		int base= 1000000007 ;
		FileUtil file = new FileUtil(path+"A-large.in");
		FileUtil ansFile = new FileUtil(path+"A-larget.out");
//		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(file.readLine());
//		int size = in.nextInt();
		for(int i = 0 ;i< size;i++){
			String cur = file.readLine().trim();
			long an =curWrodProces(cur)%base;
			ansFile.writeLine("Case #"+(i+1)+": "+an);
			System.out.println("Case #"+(i+1)+": "+an+"\t"+cur);
		}
//		in.close();
	}
	public static long curWrodProces(String word){
		long ans = 1;
		if(word == null || word.length() <2) return ans;
		// 使用dp的方法
		int len = word.length();
		long cur = 0,last = 0;
		char [] chars = word.toCharArray();
		if(chars[0] == chars[1]) last = 1;
		else last = 2;
		for(int i = 1;i < len-1;i++){
			
			Set<Character> set = new  HashSet<Character>();
			set.add(chars[i]);
			set.add(chars[i-1]);
			set.add(chars[i+1]);
			cur = set.size();
//			if(chars[i] == chars[i-1] && chars[i] == chars[i+1]){
//				cur = 1;
//			}else{
//				if(chars[i] == chars[i-1] && chars[i] != chars[i+1]){
//					cur = 2;
//				}else{
//					if(chars[i] != chars[i-1] && chars[i] == chars[i+1]){
//						cur = 2;
//					}else
//						cur = 3;
//				}
//			}
			cur = cur*last;
			last = cur;
			last = last%1000000007;
		}
		// 处理最后一个
		if(chars[len-1] == chars[len-2]){
			ans = last;
		}else{
			ans = last *2;
		}
		return ans;
		
		
	}
	
}
