package qiang.interview.goolge;

import java.util.HashSet;
import java.util.Set;

import qiang.util.FileUtil;

public class ProblemB_RobotRockBand {

	public static void main(String[] args) {
		String path = "E:\\googlejam\\";
		int aNun = 3;
		String sm = "B-small-attempt";
		String big = "B-large.in";
		int base= 1000000007 ;
		FileUtil file = new FileUtil(path+big);
		FileUtil ansFile = new FileUtil(path+"Blarget.out");
//		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(file.readLine());
//		int size = in.nextInt();
		for(int i = 0 ;i< size;i++){
			String[] cur = file.readLine().trim().split(" ");
			int N,K;
			N = Integer.parseInt(cur[0]);
			K = Integer.parseInt(cur[1]);
			String [] curL;
			int [][] alN = new int[4][N];
			for(int r = 0 ; r<4;r++){
				curL = file.readLine().trim().split(" ");
				for(int rk = 0;rk < N;rk++){
					alN[r][rk] = Integer.parseInt(curL[rk]);
				}
			}
			long an =curWrodProces(alN,N,K);
			ansFile.writeLine("Case #"+(i+1)+": "+an);
			System.out.println("Case #"+(i+1)+": "+an);
		}
//		in.close();
	}
	public static long curWrodProces(int [][]curl,int N,int K){
		
		int count = 0;
		int c1,c2,c3;
		for(int i1 = 0;i1<N;i1++){
			c1 = curl[0][i1];
			for(int i2 = 0;i2<N;i2++){
				c2 = curl[1][i2];
				for(int i3 = 0;i3<N;i3++){
					c3 = curl[2][i3];
					for(int i4 = 0;i4<N;i4++){
						if((c1 ^ c2 ^ c3 ^ curl[3][i4])==K )count++;
					}
				}
			}
		}
		return count;
	}
	
}
