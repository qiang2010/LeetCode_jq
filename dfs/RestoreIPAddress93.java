package qiang.dfs;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress93 {

	
	
	 List<String> ans;
	 
	public List<String> restoreIpAddresses(String s) {
		
		ans = new LinkedList<String>();
		
		ipAddress(s, new LinkedList<Integer>(), 0, s.length(), 1);
		 
		return ans;
	}	
	/**
	 * ip index 
	 * @param s
	 * @param b
	 * @param size
	 * @param ipIndex  表示ip生成到第几位了。
	 */
	
	public boolean ipAddress(String s,LinkedList<Integer>ip, int b,int size,int ipIndex) {
		
		if(b > size-1)return false;
		
		if(ipIndex == 4){
			// 说明已经到最后一个要生成的数了
			if(size-b >3)return false;
			int last = Integer.parseInt(s.substring(b));
			
			if(size-b==2  && last< 10) return false;
			if(size-b==3  && last< 100)return false;
			if(last > 255) {
				return false;
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<3; i++){
				sb.append(ip.get(i)+".");
			}
			sb.append(last);
			ans.add(sb.toString());
			//System.out.println(ans);
			//ip.removeLast();
			return true;
		}
		
		// 第一位是0，单独处理。
		if(b==0 && s.charAt(b) =='0'){
			ip.add(0);
			ipAddress(s, ip, b+1, size, ipIndex+1);
			ip.removeLast();
		}else{
			for(int j = 0;j < 3 && b+j < size; j++){
				
				int last = Integer.parseInt(s.substring(b,b+j+1));
				if(j== 1&& last< 10)return false;
				if(j== 2&& last< 100)return false;
				//if(j>0 && last ==0) return false;
				if(last<256){
					ip.add(last);
					ipAddress(s, ip, b+j+1, size, ipIndex+1);
					ip.removeLast();
				}else{
					return false;
				}
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		RestoreIPAddress93 ipp = new RestoreIPAddress93();
		System.out.println(ipp.restoreIpAddresses("255255255255"));
		
	}

}
