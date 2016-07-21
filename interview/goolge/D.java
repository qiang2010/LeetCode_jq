package qiang.interview.goolge;

import java.util.ArrayList;
import java.util.List;

import qiang.util.FileUtil;

public class D {
	public static void main(String[] args) {
		
		D ss = new D();
		ss.solutaion();
	}
	class  Card{
		int cost[]; // max-1; cost[i] 表示升级到i+1 的花费
		int costCuu[]; // 这里表示由当前curL 升级到 k所用的划分
		int attCuu[];
		int att[];
		int curL;
		int max;
		boolean flag = true;
		boolean costCal(){
			costCuu = new int[max-curL+1];
			attCuu = new int[max-curL+1];
			for(int j=curL;j<max+1;j++){
				attCuu[j-curL] = att[j];
			}
			costCuu[0] =0;
			int cc = 1;
			for(int i = curL;i< max;i++){
				costCuu[cc] = costCuu[cc-1]+cost[i];
				cc++;
			}
			return true;
		}
	}
	void solutaion(){
		String path = "E:\\googlejam\\";
		int aNun = 3;
		String sm = "D-small-attempt2.in";
		String big = "B-large.in";
		int base= 1000000007 ;
		String test = "1.txt";
		int samllf = 0;
		FileUtil file  =null;
		FileUtil ansFile  =null;
		
		if(samllf == 0){
			file = new FileUtil(path+test);
			ansFile = new FileUtil(path+"test.out");
		}else if(samllf == 1){// small
			file = new FileUtil(path+sm);
			ansFile = new FileUtil(path+"samll.out");
		}else{
			if(samllf==2){ // big{
				 file = new FileUtil(path+big);
				ansFile = new FileUtil(path+"large.out");
			}
		}
		int size = Integer.parseInt(file.readLine());
		for(int i = 0 ;i< size;i++){
			int paS = 0;
			String []li = file.readLine().split(" ");
			int M = Integer.parseInt(li[0]);  // number of conins
			int N = Integer.parseInt(li[1]); // 当前的卡的数量
			Card [] possCard = new Card[N];
			for(int r =0;r<N;r++){
				Card cur = new Card();
				possCard[r] = cur;
				String []cc = file.readLine().split(" ");
				cur.max = Integer.parseInt(cc[0]);
				cur.curL = Integer.parseInt(cc[1]);
				cur.cost = new int[cur.max];
				cur.att = new int[cur.max+1];
				cc = file.readLine().split(" ");
				for(int cccc =1;cccc<cur.max+1;cccc++){
					cur.att[cccc] = Integer.parseInt(cc[cccc-1]);
				}
				cc = file.readLine().split(" ");
				for(int cccc =1;cccc<cur.max;cccc++){
					cur.cost[cccc] = Integer.parseInt(cc[cccc-1]);
				}
				if(cur.costCal())
					paS+= cur.attCuu.length;
			}
			// 小问题转换成 0 1 背包问题
			System.out.println(paS);
			Package[] pg = new Package[paS];
			// 
			int cc=0;
			for(Card card: possCard){
				if(card.flag){
					for(int k = 0;k< card.attCuu.length;k++){
//						pg[cc] = new Package( card.costCuu[k],card.attCuu[k]);
						pg[cc] = new Package(card.attCuu[k], card.costCuu[k]);
						cc++;
					}
				}
			}
			int ca = this.solu(M, pg);
			ansFile.writeLine("Case #"+(i+1)+": "+ca);	
			System.out.println("Case #"+(i+1)+": "+ca);
		}
//		in.close();
	}
	int solu(int packageWheight,Package[]pg){
	 int[][] bestValues = new int[pg.length+1][packageWheight+1];  
     for(int i=0;i<=pg.length;i++){  
         for(int j=0;j<=packageWheight;j++){  
             if(i==0||j==0){  
                 bestValues[i][j]=0;//临界情况  
             }  
             else{  
                 if(j<pg[i-1].getWheight()){  
                     bestValues[i][j] = bestValues[i-1][j];//当第n件物品重量大于包的重量时，最佳值取前n-1件的  
                 }  
                 else{  
                        int iweight = pg[i-1].getWheight(); //当第n件物品重量小于包的重量时，分两种情况，分别是装第n件或不装，比较取最大  
                         int ivalue = pg[i-1].getValue();      
                         bestValues[i][j] =       
                             Math.max(bestValues[i-1][j], ivalue + bestValues[i-1][j-iweight]);            
                 }  
             }  
         }  
     }  
     return bestValues[pg.length][packageWheight];  
     }  
 class Package {  

	 int value;  
	 int wheight;  
	 Package(int value,int wheight){  
	     this.value=value;  
	     this.wheight=wheight;  
	 }  
	 public int getWheight(){  
	     return wheight;  
	 }  
	 public int getValue(){  
	     return value;  
	 }  
	 public String getName(){ 
		 return "";
	 }  
	 
 }
}

