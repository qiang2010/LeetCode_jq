package qiang.leetcode.util;

import java.util.List;

public class PrintUtil {

	
	public static void printArray(int [][] in){
		int row = in.length;
		int col = in[0].length;
		
		for(int i=0;i<row;i++){
			for(int j =0; j< col; j++){
				System.out.print(in[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public static void printArray(char [][] in){
		int row = in.length;
		int col = in[0].length;
		
		for(int i=0;i<row;i++){
			for(int j =0; j< col; j++){
				System.out.print(in[i][j]+"  ");
			}
			System.out.println();
		}
	}

	public static <E> void print2DList(List<List<E>>  in){
		int row = in.size();
		for(int i=0;i<row;i++){
			for(int j =0; j< in.get(i).size(); j++){
				System.out.print(in.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
 
	
	public static void printArray(double [][] in){
		int row = in.length;
		int col = in[0].length;
		
		for(int i=0;i<row;i++){
			for(int j =0; j< col; j++){
				System.out.print(in[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void printArray(boolean [][] in){
		int row = in.length;
		int col = in[0].length;
		
		for(int i=0;i<row;i++){
			for(int j =0; j< col; j++){
				System.out.print(in[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void printArray(String [][] in){
		int row = in.length;
		int col = in[0].length;
		
		for(int i=0;i<row;i++){
			for(int j =0; j< col; j++){
				System.out.print(in[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
