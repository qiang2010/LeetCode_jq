package qiang.leetcode.util;

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
