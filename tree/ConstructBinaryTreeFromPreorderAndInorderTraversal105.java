package qiang.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
		
	}
	TreeNode build(int[] preorder,int pLeft ,int pRight, int[] inorder,int iLeft ,int iRight){
		
//		if(pLeft == pRight){
//			return new TreeNode(preorder[pLeft]);
//		}
		if(pLeft > pRight) return null;
		TreeNode tempNode = new TreeNode(preorder[pLeft]);
		int rootVal = preorder[pLeft];
		int i  = iLeft;
		for( i= iLeft; i < iRight+1; i++){
			if(inorder[i] == rootVal) break;
		}
		tempNode.left  = build(preorder, pLeft+1, pLeft+i-iLeft, inorder, iLeft, i-1);
		tempNode.right  = build(preorder, pLeft+i-iLeft+1, pRight, inorder, i+1, iRight);
		return tempNode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromPreorderAndInorderTraversal105 tt = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
		int first[] = {1,2,3,4};
		int mid[] = {2,4,3,1};
		TreeNode root = tt.buildTree(first, mid);
		TreeAlg.preOrder(root);
		TreeAlg.postOrder(root);
	}

}
