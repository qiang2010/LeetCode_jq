package qiang.indeedTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Quantile {

	
	public static void main(String[] args) {
		
		Quantile aa = new Quantile();
		aa.quantile();
		
	}
	class InNode{
		int value;
		int count ;
		InNode(int value, int count){
			this.value = value;
			this.count = count;
		}
	}
	void quantile(){
		Scanner in= new Scanner(System.in);
		int N  = in.nextInt();
		int K = in.nextInt();
		List<InNode> inputs = new ArrayList<>();
		int  sumCount = 0;
		for(int i =0;i< N;i++){
			int va = in.nextInt();
			int c = in.nextInt();
			inputs.add(new InNode(c,va));
			sumCount += c ;
		}
		in.close();
		Comparator<InNode> com = new Comparator<InNode>(){
			public int compare(InNode one, InNode two){
				if(one.value != two.value){
					return Integer.compare(one.value, two.value);
				}else return Integer.compare(one.count, two.count);
			}
		};
		inputs.sort(com);
		int count = 1;
		int index = -1;
		int curSize = 0;
		while( count < K){
			// 找第count个数
			int ci = sumCount*count/K; 
			while(index < N && curSize < ci ){
				index++;
				curSize += inputs.get(index).count;
			}
			System.out.println(inputs.get(index).value);
			count++;
		}
	}
	
}
