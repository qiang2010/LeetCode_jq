package qiang.hiho.hiho1;

import java.util.Scanner;

public class ZhiLiJingSai3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int allT = in.nextInt();
		while(allT > 0){
			String line = in.nextLine();
			String []splits = line.split("\\s+");
			int N = in.nextInt();
			int M = in.nextInt();
			int S = in.nextInt();
			int T = in.nextInt();
			int [] ai = new int[N];
			for(int j =0;j<N;j++)ai[j]= in.nextInt();
			System.out.println(ai[1]);
			int re = 0;
			int []everyYesPro = new int[N]; // 每次最少答题正确的数量，因为答题正确的得分更高，所以尽量先答对题目
			int []everyLeftScore = new int[N];//除去答对的，剩下的分数。
			int leftScoreSum = 0;
			for(int i =0;i<N;i++){
				everyYesPro[i] = ai[i]/S;
				re+=everyYesPro[i];
				everyLeftScore[i] = ai[i]-everyYesPro[i]*S;
				leftScoreSum +=everyLeftScore[i];
				if(re >M){
					System.out.println("No");
					allT--;
					continue;
				}
			}
			// 如果剩余的总分数，
			
			allT--;
			if(re <=M)
				System.out.println(re);
			
		}
		in.close();
		
	}
}
