package qiang.leetcode5;

import java.util.Arrays;

public class RectangleArea223 {

	
   public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       
       int area =0;
       int areaA = (A-C)*(B-D);
       areaA = areaA>0? areaA: -areaA;
       int areaB = (E-G)*(F-H);
       areaB = areaB >0? areaB: -areaB;
      //if(A==C && B==D || E==G && F==H) return 0;    
	   if(A>G || C < E ||B>H ||D<F ) area = 0;
	   else{
	   // 为了减少判断，可以将x排序，中间两个数字的差就是一个边长，对y一样
	   int []left = {A,C,E,G};
	   int []top =  {B,D,F,H};
	  Arrays.sort(left);
	  Arrays.sort(top);
	  area = (left[1]-left[2])*(top[1]-top[2]);
	  area = area < 0? -area: area;
	       
	   }
	  
	 return areaA+areaB -area;
  
   }
	  
	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
		System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}

}
