package qiang.tree;

public class ConstructBinaryTreeFromInorderAndPostTraversal106 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
		
	}
	TreeNode build(int[] inorder,int pLeft ,int pRight, int[] postorder,int iLeft ,int iRight){
		
//		if(pLeft == pRight){
//			return new TreeNode(preorder[pLeft]);
//		}
		if(iLeft > iRight) return null;
		TreeNode tempNode = new TreeNode(postorder[iRight]);
		int rootVal = postorder[iRight];
		int i  = pLeft;
		for( i= pLeft; i < pRight+1; i++){
			if(inorder[i] == rootVal) break;
		}
		tempNode.left  = build(inorder, pLeft, i-1, postorder, iLeft, iLeft+i-pLeft-1);
		tempNode.right  = build(inorder, i+1, pRight, postorder, iLeft+i-pLeft, iRight-1);
		return tempNode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromInorderAndPostTraversal106 tt = new ConstructBinaryTreeFromInorderAndPostTraversal106();
		int postorder[] = {4,3,2,1};
		int inorder[] = {2,4,3,1};
		TreeNode root = tt.buildTree(inorder, postorder);
		TreeAlg.preOrder(root);
		TreeAlg.postOrder(root);
	}

}
