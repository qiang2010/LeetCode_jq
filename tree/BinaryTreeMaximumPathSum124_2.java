package qiang.tree;

public class BinaryTreeMaximumPathSum124_2 {

	 class  OnePath{
	        int leftP;
	        int rightP;
	        int curP;
	        OnePath(TreeNode root){
	            curP = root.val;
	             leftP = rightP = 0;
	        }
	        OnePath(int l,int r,int m){
	            leftP = l;
	            rightP = r;
	            curP = m;
	        }
	    }
	    int maxP = Integer.MIN_VALUE;
	    public int maxPathSum(TreeNode root) {
	        if(root == null) return 0;
	        OnePath one = inter(root);
	        int t = one.leftP + one.rightP + root.val;
	        if(t > maxP) return t;
	        return maxP;
	    }
	    
	    OnePath inter(TreeNode root){
	        if(root == null) return null;
	        //if(root.left == null && root.right ==null) return new OnePath(root);
	        OnePath leftS = inter(root.left);
	        OnePath rightS = inter(root.right);
	        // 合并
	        int leftM = maxPP(leftS);
	        int rightM = maxPP(rightS);
	        int cur = leftM + rightM + root.val;
	        if(cur > maxP ) maxP = cur;
	        return new OnePath(leftM,rightM,root.val);
	    }
	    int maxPP(OnePath one){
	        if(one == null) return 0;
	        int maxL = Math.max(one.leftP,one.rightP);
	        maxL = maxL > 0? maxL : 0;
	        return (maxL+one.curP) > 0? (maxL+one.curP):0;
	    }
	public static void main(String[] args) {

		TreeNode root = TreeAlg.getTreeForSerialized("123");
		System.out.println(new BinaryTreeMaximumPathSum124_2().maxPathSum(root));
		StringBuilder sb = new StringBuilder("aaa");
	}

}
