package qiang.tree;

public class VerifyPreorderSerializationofaBinaryTree331 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyPreorderSerializationofaBinaryTree331 vv = new VerifyPreorderSerializationofaBinaryTree331();
		System.out.println(vv.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

    /**
     * 给定一个树的先根遍历，判断先跟遍历是否是合法的。
     * @param preorder
     * @return
     */
	public boolean isValidSerialization(String preorder) {
    
		if(preorder == null || "".equals(preorder)) return true;
		int degree =-1;
		String []splits = preorder.split(",");
		for(String s:splits){
			degree++;
			if(degree >0)return false;
			if(!s.equals("#")){
				degree -=2;
			}
		}
		return degree==0? true:false;
	}
	
}
