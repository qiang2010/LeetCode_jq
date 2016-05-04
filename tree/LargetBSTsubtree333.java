package qiang.tree;

public class LargetBSTsubtree333 {

	public static void main(String[] args) {

		LargetBSTsubtree333 bb = new LargetBSTsubtree333();
		TreeNode root = TreeAlg.getTreeForSerialized("52413##");
		System.out.println(bb.largestBST(root));
	}
	
	int maxBSTSize = Integer.MIN_VALUE;
	
	int largestBST(TreeNode root) {
		 if(root == null) return 0;
		  postOrder(root);
		 return maxBSTSize;
    }
	class NodeInfo{
		int bstSize ;
		int max;
		int min;
		NodeInfo(TreeNode node){
			max = node.val;
			min = node.val;
			bstSize = 1;
		}
	}
	NodeInfo postOrder(TreeNode root){
		// 保证root不会为null
		if(root == null) return null;
		
		NodeInfo left = postOrder(root.left);
		NodeInfo right = postOrder(root.right);
		NodeInfo cur = new NodeInfo(root);
		if(left == null && right == null)return cur;
		if(left !=null && right !=null){
			// 左右都不为空，那么有三种情况，一个是root和left和right一起构建一个BST
			// 1. 三个共同构建
			if(root.val >= left.max && root.val<= right.min ){
				cur.max = right.max;
				cur.bstSize = 1+ left.bstSize+right.bstSize;
				cur.min = left.min;
			}else{
				// 可以和左侧的合并
				if(root.val>=left.max){
					cur.max= root.val;
					cur.bstSize =1+left.bstSize;
				}else{// 可以和右侧的合并
					cur.max = right.max;
					cur.bstSize = right.bstSize+1;
				}
			}
		}else{
			if(left !=null){
				if(root.val>= left.max){
					cur.max= root.val;
					cur.bstSize =1+left.bstSize;
				}
			}else{
				if(root.val <= right.min){
					cur.max = right.max;
					cur.bstSize = right.bstSize+1;
				}
			}
		}
		if(cur.bstSize > maxBSTSize)maxBSTSize = cur.bstSize;
		return cur;
	}
}
