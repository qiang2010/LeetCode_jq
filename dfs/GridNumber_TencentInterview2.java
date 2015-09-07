package qiang.dfs;

public class GridNumber_TencentInterview2 {
	
	public static void allAns(){
		// 第一层 for a的取值
		int a[] = new int[8]; 
		for( a[0] = 0 ; a[0] <5; a[0]++){
			 a[1] = 13 -a[0];
			// c
			for(a[2] = 0; a[2] < 6; a[2]++){
				a[3] = 5 - a[2];
				for( a[4] =1; a[4] <= a[1] -4; a[4]++){
					if((a[1]-4)%a[4]==0){
						a[5] = (a[1]-4)/a[4];
						// 这里继续判断 6 7 位置
						a[6] = 4 + a[3] - a[5];
						a[7] = 4 + a[4]*a[2];
						if(a[6]>0  && a[7] >-1 && a[7]%a[6]==0 && a[0] + a[7]/a[6]==4 ){
							// 得到一个解
							for(int i =0 ; i < 8; i++){
								System.out.print(a[i]+" ");
							}
							System.out.println();
						}
					}else {
						continue;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allAns();
	}

}
