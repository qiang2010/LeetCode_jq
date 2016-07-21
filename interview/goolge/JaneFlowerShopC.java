package qiang.interview.goolge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import qiang.util.FileUtil;

public class JaneFlowerShopC {
	public static void main(String[] args) {
		String path = "E:\\googlejam\\";
		int aNun = 3;
		String sm = "C-small-attempt0.in";
		String big = "C-large-practice.in";
		int base= 1000000007 ;
		String test = "1.txt";
		int samllf = 2;
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
				ansFile = new FileUtil(path+"largeC.out");
			}
		}
		int size = Integer.parseInt(file.readLine());
		int count =1; 
		while (count <= size) {
			int n =Integer.parseInt(file.readLine());
			double result = 0l;
			double[] val = new double[n+1] ;
			int index = 0;
			String cul[]= file.readLine().split(" ");
			while(index<=n){
				val[index] = Double.parseDouble(cul[index]);
				index++;
			}
			val[0] = -val[0];
			double d = 1d,f,fd,x0 = 2;
			int k;
			while (Math.abs(d) > 1e-9) {
				f = 0;
				k = n;
				for (int i = 0; i <= n; i++) {
					f += val[i] * Math.pow(x0, (double) n - i);
				}
				List<Double> list = new ArrayList<Double>();
				for (int i = 0; i < n; i++) {
					list.add(val[i] * (n - i));
				}
				fd = 0;
				k--;
				for (int i = 0; i <= k; i++) {
					fd += list.get(i) * Math.pow(x0, (double) k - i);
				}
				d = f / fd;
				result = x0 - d;
				x0 = result;
			}
			result-=1;
			System.out.println("Case #"+count+": "+result);
			ansFile.writeLine("Case #"+count+": "+result);
			count++;
		}
		
	}
	
}