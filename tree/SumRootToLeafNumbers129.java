package qiang.tree;

public class SumRootToLeafNumbers129 {
	
    
	
	int ans = 0;
	int pathSum=0;
	public int sumNumbers(TreeNode root) {
        if(root == null) return ans;
        pathSum = root.val;
        dfs(root);
        return ans;
	}
	public void dfs(TreeNode root){
		if(root!=null && root.left==null && root.right == null){
			//pathSum  = pathSum*10+root.val;
			ans += pathSum;
			// 回溯准备
			//pathSum=(pathSum-root.val)/10;
			return;
		}
		if(root.left!=null){
			pathSum = pathSum*10+root.left.val;
			dfs(root.left);
			pathSum=(pathSum-root.left.val)/10;
		}
		if(root.right!=null){
			pathSum = pathSum*10+root.right.val;
			dfs(root.right);
			pathSum=(pathSum-root.right.val)/10;
		}
	}
	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("123");
		TreeAlg.preOrder(root);
		System.out.println(new SumRootToLeafNumbers129().sumNumbers(root));
	}
	

}
