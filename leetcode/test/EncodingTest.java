package qiang.leetcode.test;

public class EncodingTest {

	
	
	public static void main(String[] args) {
		
		// 获取当前文件存储的编码方式
		System.out.println("file.encoding: "+ System.getProperty("file.encoding"));
		
		
		String str = "姬强";
		String str2 = "ab强";
		
		// String的lenght方法实际上返回的是代码点的数量。
		System.out.println("String的lenght方法实际上返回的是代码点的数量。");
		System.out.println(str+":"+str.length());
		System.out.println(str2+": "+str2.length());

		// 获取存储大小
		System.out.println("获取存储大小");
		System.out.println(str+":"+str.getBytes().length);
		System.out.println(str2+":"+str2.getBytes().length);
		
		// 按照String lenght长度输出代码点。
		System.out.println("按照String lenght长度输出代码点。");
		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.codePointAt(i)+"  ");
		}
		System.out.println();
		System.out.println(str2);
		for (int i = 0; i < str2.length(); i++) {
			System.out.print(str2.codePointAt(i)+"  ");
		}
		
		// 输出bytes
		System.out.println();
		System.out.println("输出bytes");
		System.out.println(str);
		byte[] strBytes = str.getBytes();
		for(byte b: strBytes){
			System.out.print(b+"  ");
		}
	 
		System.out.println();
		System.out.println(str2);
		byte[] str2Bytes = str2.getBytes();
		for(byte b: str2Bytes){
			System.out.print(b+"  ");
		}
		
	}
	
}
