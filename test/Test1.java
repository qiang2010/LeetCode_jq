package qiang.test;

import java.util.Arrays;
import java.util.HashMap;

public class Test1 {

	
	public static void main(String[] args) {
 
        int a[] = new int[] {1, 3, 4, 6, 8, 10};
        int x1 = Arrays.binarySearch(a, 5); // 第一个大于5的数是6，位置是4. 于是返回-4
        int x2 = Arrays. binarySearch(a,3,3, 6); // 返回2
        int x3 = Arrays. binarySearch(a, 0); //返回-1，第一个大于的数在数组中的位置是1.
        int x4 = Arrays. binarySearch(a, 10); // 没有大于10的返回 -（len+1）
        int x5 = Arrays. binarySearch(a, 9); // 没有大于10的返回 -（len+1）
       System. out.println( "x1:" + x1 + ", x2:" + x2);
       System. out.println( "x3:" + x3 + ", x4:" + x4);
       System. out.println( "x3:" + x3 + ", x5:" + x5);
	}
	
}
