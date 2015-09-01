package qiang.leetcode.test;


/**
 * 
 * 	JVM 在开始运行后，IntegerCache会自动在内存中缓存 一定范围内的整数，当我们在程序中申请整数变量的时候，会自动返回这些
 *  对象的地址，而不会重新分配。
 * 
 * @author  jq
 *
 */
public class IntegerCacheTest {

	public static void isTwoIntegerSame(){
		
		Integer a = 1;
		Integer b = 1;
		
		System.out.println("a == b : " + (a==b));
	
		
		Integer c = 10000;
		
		Integer d = 10000;
		
		System.out.println("c == d : "+(c==d));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer e = 10000;
		System.out.println("e == c : " + (e==c));
		System.out.println("e == d : " + (e==d));
		
		
		Integer ab = new Integer(3);
		Integer ac = new Integer(3);
		System.out.println(ab == ac);
	}
	
	/**
	 * 对于String 常量，如果没有了对其的引用，那么它会被释放吗？
	 * 比如 开始我String j = "qiang";
	 * 然后j = null;
	 * 
	 * 等到一段时间后，我String a= "qiang";
	 * 那么 a的地址 和 j曾经的地址一样吗？
	 * （由于java不能直接获取一个对象的地址，所以。。）
	 */
	public static void isTowStringSameAdd(){
		
		String j = "qiang";
		String q = "qiang";
		System.out.println(j == q);
		
		//q = null;
		//j = null;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String m = "qiang";
		j = "qiang";
				
		System.out.println(m==j);
		
	}
	
	public static void  isLongSame(){
		Long a = 1l;
		Long b = 1l;
		System.out.println(a==b);
		
	}
	
	public static void isBooleanSame(){
		Boolean a = true;
		Boolean b = true;
		
		System.out.println(a==b);
		
		Boolean c = false;
		Boolean e = false;
		System.out.println( c == e);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerCacheTest.isTwoIntegerSame();
	}

}
