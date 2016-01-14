package qiang.tree;


import qiang.list.ListNode;

public class ConvertSortedListToBinarySearchTree109 {

	/**
	 *  这种方法首先将list转换成数组。然后按照108题目
	 * @param head
	 * @return
	 */
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
	
	/**
	 *  上面的方法需要额外的空间。下面我们不使用额外空间。
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST2(ListNode head) {
		
		if(head == null)return null;
	    
		int len = listLen(head);
		if(len ==1)return new TreeNode(head.val);
		return buildBST2(head,0,len-1);
	}
	
	TreeNode buildBST2(ListNode list,int begin, int end){
		
		if(begin > end){
			return null;
		}
		if(begin == end){
			return new TreeNode(list.val);
		}
		
		int mid = (begin+end)/2;
		ListNode midNode  = findMid(list, mid-begin);
		TreeNode root = new TreeNode(midNode.val);
		root.left = buildBST2(list, begin, mid-1);
		root.right = buildBST2(midNode.next, mid+1, end);
		return root;
	}
	
	
	/**
	 * 返回head开始的第cur个点。
	 * @param head
	 * @param cur
	 * @return
	 */
	ListNode findMid(ListNode head,int cur){
		
		if(cur ==0)return head;
		
		int c =0;
		while(c < cur){
			head = head.next;
			c++;
		}
		return head;
	}
	
	int listLen(ListNode root){
		
		int c=0;
		if(root == null)return c;
		while(root!=null){
			c++;
			root = root.next;
		}
		return c;
	}
	
	
	/**
	 *  这种方法首先将list转换成数组。然后按照108题目
	 * @param head
	 * @return
	 */
	ListNode node;
    public TreeNode sortedListToBST3(ListNode head) {
    	// List<Integer> list = new ArrayList<>();
    	 ListNode tempHead = head;
    	 int count =0;
    	 while(tempHead != null){
    		 count++;
    		 tempHead = tempHead.next;
    	 }
    	 node = head;
    	 return buildBST3(0,count-1);
    }
    public TreeNode buildBST3(int begin,int end){
    	
    	if(begin > end)return null;
    	int mid = (begin + end)/2;
    	TreeNode left = buildBST3(begin, mid-1);
    	TreeNode root = new TreeNode(node.val);
    	root.left = left;
    	node = node.next;
    	root.right = buildBST3(mid+1,end);
    	return root;
    }
	
	
    
	public static void main(String[] args) {

			int []nums= {1,2,3,4,5,6,7,8,9};
			ConvertSortedListToBinarySearchTree109 cc = new ConvertSortedListToBinarySearchTree109();
			ListNode he = ListNode.getListByNums(nums);
			//ListNode.printList(he);
			TreeNode root = cc.sortedListToBST3(he);
			TreeAlg.preOrder(root);
			System.out.println();
			TreeAlg.postOrder(root);
			he = ListNode.getListByNums(nums);
			TreeAlg.preOrder(cc.sortedListToBST(he));
	}

}
