package qiang.tree;

public class ConvertSortedArrayToBinarySearchTree108 {

	
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
	
	
	private TreeNode buildBST(int []nums,int left,int right){
		if(left > right ) return null;
		// 这里会保证left < nums.length
		if(left == right){
			return new TreeNode(nums[left]);
		}
		int mid = (left + right)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBST(nums, left, mid-1);
		root.right = buildBST(nums, mid+1, right);
		return root;
	}
	
	
	
	public static void main(String[] args) {

			int []nums= {1,2,3,4,5,6,7,8,9};
			ConvertSortedArrayToBinarySearchTree108 cc = new ConvertSortedArrayToBinarySearchTree108();
			TreeNode root = cc.sortedArrayToBST(nums);
			TreeAlg.preOrder(root);
			System.out.println();
			TreeAlg.postOrder(root);
	}

}
