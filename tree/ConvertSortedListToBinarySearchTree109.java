package qiang.tree;


import qiang.list.ListNode;

public class ConvertSortedListToBinarySearchTree109 {

	
    public TreeNode sortedListToBST(ListNode head) {
    	// List<Integer> list = new ArrayList<>();
    	 ListNode tempHead = head;
    	 int count =0;
    	 while(tempHead != null){
    		// list.add(head.val);
    		 count++;
    		 tempHead = tempHead.next;
    	 }

    	 int []nums = new int[count];
    	 count =0;
    	 while(head != null){
    		 nums[count++] = head.val;
    		 head = head.next;
    	 }
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
			ConvertSortedListToBinarySearchTree109 cc = new ConvertSortedListToBinarySearchTree109();
			
			TreeNode root = cc.sortedListToBST(ListNode.getListByNums(nums));
			TreeAlg.preOrder(root);
			System.out.println();
			TreeAlg.postOrder(root);
	}

}
