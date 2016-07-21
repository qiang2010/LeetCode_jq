package qiang.interview.goolge;

import java.util.ArrayList;
import java.util.List;

import qiang.util.FileUtil;

public class CopyOfD {
	public static void main(String[] args) {
		
		CopyOfD ss = new CopyOfD();
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
		String sm = "B-small-attempt1.in";
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
			Knapsack[] pg = new Knapsack[paS];
			int []val = new int[paS];
			int []w = new int[paS];
			// 
			int cc=0;
			for(Card card: possCard){
				if(card.flag){
					for(int k = 0;k< card.attCuu.length;k++){
						pg[cc] = new Knapsack( card.costCuu[k],card.attCuu[k]);
//						pg[cc] = new Package(card.attCuu[k], card.costCuu[k]);
						val[cc] = card.attCuu[k];
						w[cc] = card.costCuu[k];
						cc++;
					}
				}
			}
			 KnapsackProblem kp = new KnapsackProblem(pg,M);
			 kp.solve();
			 int ca =kp.getBestValue();
			ansFile.writeLine("Case #"+(i+1)+": "+ca);	
			ansFile.writeLine("Case #"+(i+1)+": "+Knapsack2.knapsack(val, w, M));	
			System.out.println("Case #"+(i+1)+": "+ca);
		}
//		in.close();
	}
	class Knapsack {
	    
	    /** 背包重量  */
	    private int weight;
	    
	    /** 背包物品价值  */
	    private int value;
	    /***
	     * 构造器
	     */
	    public Knapsack(int weight, int value) {
	        this.value = value;
	        this.weight = weight;
	    }
	    public int getWeight() {
	        return weight;
	    }
	    
	    public int getValue() {
	        return value;
	    }
	    public String toString() {
	        return "[weight: " + weight + " " + "value: " + value + "]";  
	    }
	} 
	 class KnapsackProblem {
		    
		    /** 指定背包 */
		    private Knapsack[] bags;
		    
		    /** 总承重  */
		    private int totalWeight;
		    
		    /** 给定背包数量  */
		    private int n;
		    
		    /** 前 n 个背包，总承重为 totalWeight 的最优值矩阵  */
		    private int[][] bestValues;
		    
		    /** 前 n 个背包，总承重为 totalWeight 的最优值 */
		    private int bestValue;
		    
		    /** 前 n 个背包，总承重为 totalWeight 的最优解的物品组成 */
		    private ArrayList<Knapsack> bestSolution;
		    
		    public KnapsackProblem(Knapsack[] bags, int totalWeight) {
		        this.bags = bags;
		        this.totalWeight = totalWeight;
		        this.n = bags.length;
		        if (bestValues == null) {
		            bestValues = new int[n+1][totalWeight+1];
		        }
		    }
		    
		    /**
		     * 求解前 n 个背包、给定总承重为 totalWeight 下的背包问题
		     * 
		     */
		    public void solve() {
		        
		        System.out.println("给定背包：");
		        for(Knapsack b: bags) {
		            System.out.println(b);
		        }
		        System.out.println("给定总承重: " + totalWeight);
		        
		        // 求解最优值
		        for (int j = 0; j <= totalWeight; j++) {
		            for (int i = 0; i <= n; i++) {
		            
		                if (i == 0 || j == 0) {
		                    bestValues[i][j] = 0;
		                }    
		                else 
		                {
		                    // 如果第 i 个背包重量大于总承重，则最优解存在于前 i-1 个背包中，
		                    // 注意：第 i 个背包是 bags[i-1]
		                    if (j < bags[i-1].getWeight()) {
		                        bestValues[i][j] = bestValues[i-1][j];
		                    }    
		                    else 
		                    {
		                        // 如果第 i 个背包不大于总承重，则最优解要么是包含第 i 个背包的最优解，
		                        // 要么是不包含第 i 个背包的最优解， 取两者最大值，这里采用了分类讨论法
		                        // 第 i 个背包的重量 iweight 和价值 ivalue
		                        int iweight = bags[i-1].getWeight();
		                        int ivalue = bags[i-1].getValue();
		                        bestValues[i][j] = 
		                            Math.max(bestValues[i-1][j], ivalue + bestValues[i-1][j-iweight]);        
		                    } // else
		                } //else         
		           } //for
		        } //for
		        
		        // 求解背包组成
		        if (bestSolution == null) {
		            bestSolution = new ArrayList<Knapsack>();
		        }
		        int tempWeight = totalWeight;
		        for (int i=n; i >= 1; i--) {
		           if (bestValues[i][tempWeight] > bestValues[i-1][tempWeight]) {
		               bestSolution.add(bags[i-1]);  // bags[i-1] 表示第 i 个背包
		               tempWeight -= bags[i-1].getWeight();
		           }
		           if (tempWeight == 0) { break; }
		        }
		        bestValue = bestValues[n][totalWeight];
		       }
		    
		    /**
		     * 获得前  n 个背包， 总承重为 totalWeight 的背包问题的最优解值
		     * 调用条件： 必须先调用 solve 方法
		     * 
		     */
		    public int getBestValue() {    
		        return bestValue;
		    }
		    
		    /**
		     * 获得前  n 个背包， 总承重为 totalWeight 的背包问题的最优解值矩阵
		     * 调用条件： 必须先调用 solve 方法
		     * 
		     */
		    public int[][] getBestValues() {
		        
		        return bestValues;
		    }
		    
		    /**
		     * 获得前  n 个背包， 总承重为 totalWeight 的背包问题的最优解值矩阵
		     * 调用条件： 必须先调用 solve 方法
		     * 
		     */
		    public ArrayList<Knapsack> getBestSolution() {
		        return bestSolution;
		    }
		    
		}
}

