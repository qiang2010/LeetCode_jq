package qiang.leetcode;

public class CompareVersionNumber165 {

	
	
	 
	
	/**
	 *  version1和2都是非空，并且只是包含数字和小数点。
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) { 
		
		String []parts1  = version1.split("\\.");
		String []parts2 = version2.split("\\.");
		int s1 = parts1.length;
		int s2 = parts2.length;
		int i ,j;
		for( i =0 ,j =0; i<s1 && j < s2; i++,j++){
			int ans = com(parts1[i], parts2[j]);
			if(ans > 0) return 1;
			if(ans < 0 ) return -1;
		}

		if( i == s1 && j == s2)return 0;
		if(i == s1) {
			while( j <s2 && preZeros(parts2[j]).equals("0")) j++;
			if( j == s2) return 0;
			return -1;
		}
		while( i < s1 && preZeros(parts1[i]).equals("0"))i++;
		if(i == s1) return 0; 
		return 1;
	}
	
	// 特定版本的大小
	
	private int com(String v1,String v2){
		
		v1 = preZeros(v1);
		v2 = preZeros(v2);
		
		int size1 = v1.length();
		int size2 = v2.length();
		
		if(size1 > size2) return 1;
		if(size1 < size2) return -1;
		int ans = v1.compareTo(v2);
		if(ans == 0) return 0;
		if(ans < 0) return -1;
		return 1;
		
	}
	private String preZeros(String version1){
		int i =0;
		while(i < version1.length() &&version1.charAt(i)=='0' ){
			++i;
		}
		if(i == version1.length())return "0";
		if(i == 0) return version1;
		return version1.substring(i);
	}
	
	public static void main(String[] args) {
		
		System.out.println(new CompareVersionNumber165().compareVersion("01.0.0.00000", "1.0"));
		
		
	}
}
