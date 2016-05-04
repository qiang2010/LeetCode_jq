package qiang.tree;

/**
 * 求解一个树 的宽度 
 * @author jq
 * 
 *
 */
public class TreeWidth {

	public static void main(String[] args) {
		
		TreeWidth ww = new TreeWidth();
		TreeNode root = TreeAlg.getTreeForSerialized("1234567");
		TreeAlg.preOrder(root);
		System.out.println();
		TreeAlg.inOrder(root);
		System.out.println(ww.maxWdith(root));
	}
	
	
	int min=0,max = 0;
	int maxWdith(TreeNode root){
		if(root == null)return 0;
		preOrder(root,0);
		System.out.println(min +"  "+max);
		return max-min+1;
		
	}
	void preOrder(TreeNode root, int curW){
		if(root==null)return;
		min = min < curW ? min:curW;
		max = max > curW ? max: curW;
		preOrder(root.left,curW-1);
		preOrder(root.right,curW+1);
	}
	
	
	
}
