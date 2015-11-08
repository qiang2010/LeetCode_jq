package qiang.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class LowestCommonAncestorOfBinaryTree236 {

	
	/**
	 * 记录从根到p和q的路径，然后从根往下依次判断就可以了。
	 * 找到从根到一个节点的路径：
	 * 使用一个栈，模拟先根遍历，遍历的过程中，当找到该节点的时候，栈中的节点就是相应的路径。
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		ArrayList<LinkedList<TreeNode>>  pAllPath = getReversePath(root, p);
     	ArrayList<LinkedList<TreeNode>>  qAllPath = getReversePath(root, q );
		for(LinkedList<TreeNode> tempLinkedList: pAllPath){
			for(TreeNode temp:tempLinkedList){
				System.out.print(temp.val+" ");
				}
			System.out.println();
		}
		
		for(LinkedList<TreeNode> tempLinkedList: qAllPath){
			for(TreeNode temp:tempLinkedList){
				System.out.print(temp.val+" ");
				}
			System.out.println();
		}
		int pAllSize = pAllPath.size();
		int qAllSize = qAllPath.size();
		LinkedList<TreeNode> one_pPathLinkedList;
		LinkedList<TreeNode> one_qPathLinkedList;
		int size1,size2,minSize;
		int min = 0;
		TreeNode lowestNode = null;
		for(int j =0; j< pAllSize ; j++){
			one_pPathLinkedList = pAllPath.get(j);
			size1 = one_pPathLinkedList.size();
			for(int k =0; k < qAllSize ; k ++){
				one_qPathLinkedList = qAllPath.get(k);
				size2 = one_qPathLinkedList.size();
				System.out.println( size1 + " :" +size2);
				
				minSize = size1>size2? size2:size1;
				int i = 0 ; 
				//System.out.println("size1" +minSize);
				for( i = 0 ; i < minSize; i++){
					if(one_pPathLinkedList.get(i)  == one_qPathLinkedList.get(i) ){
						continue;
					}else{
						break;
					}
				}
 
				//System.out.println("it " +i);
				if(i > min ){
					min = i;
					//System.out.println(min);
					lowestNode = one_pPathLinkedList.get(i-1);
					//System.out.println(lowestNode.val);
				}
				
			}
		}


		return lowestNode;
	}
	
	static ArrayList<LinkedList<TreeNode>>  getReversePath(TreeNode rootNode,TreeNode q){
		ArrayList<LinkedList<TreeNode>> allPathArrayList  = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> stackLinkedList = new LinkedList<TreeNode>();
		LinkedList<TreeNode> tempLinkedList ;
		LinkedList<Boolean> stackFlagList = new LinkedList<Boolean>();
		if(rootNode == null) return allPathArrayList;
		
		TreeNode tempNode = rootNode;
//		boolean flag= false;
		while(tempNode !=null || !stackLinkedList.isEmpty()){
			while(tempNode!=null){
				stackLinkedList.addLast(tempNode);
				stackFlagList.addLast(false);
				if(tempNode  == q  ) {
					
					tempLinkedList = (LinkedList<TreeNode>) stackLinkedList.clone();
					allPathArrayList.add(tempLinkedList);
					//return stackLinkedList; 
				}
				tempNode = tempNode.left;
			}
			tempNode = stackLinkedList.getLast().right;
		
			// 如果栈顶元素的右子树为null，那么将该节点弹出，继续判断，栈顶元素的flag 如果为true，说明应该继续弹出
			// flag 说明当前节点以及其左右子树都不会是该路径上的节点，应该弹出
			if(tempNode == null) {
				// 首先将栈顶元素及其flag弹出
				stackFlagList.removeLast();
				stackLinkedList.removeLast();
				//System.out.println(stackLinkedList.size() +" " + stackFlagList.size());
				// 将栈顶中flag为true的都弹出
				while(  !stackFlagList.isEmpty() && stackFlagList.getLast()){
					stackFlagList.removeLast();
					stackLinkedList.removeLast();
				}
				if(stackFlagList.isEmpty()) break;
				tempNode = stackLinkedList.getLast().right;
				// 记得此时将其对应flag置为true
				stackFlagList.removeLast();
				stackFlagList.addLast(true);
			}// 当前节点的右子树不为空，说明可以入栈，将当前节点的flag置为 true
			else {
//				tempNode = stackLinkedList.pop();
				stackFlagList.removeLast();
				stackFlagList.addLast(true);
				//System.out.println(stackLinkedList.size() +" " + stackFlagList.size());
			}
		}
		return allPathArrayList;
		
	}
	
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	     if(root == null ) return null;
	     if(p==null || q == null)return null;
	     // 下面是||，开始的时候使用&& 
	     if(p.val== root.val || q.val == root.val) return root;
		 if(containsNode(root.left, p) && containsNode(root.right, q) || containsNode(root.left, q) && containsNode(root.right, p)){
			 return root;
		 }
	     if(containsNode(root.left, p) && containsNode(root.left, q)||containsNode(root.left, q) && containsNode(root.left, p)){
			 return lowestCommonAncestor(root.left, p, q);
		 }
	     if(containsNode(root.right, p) && containsNode(root.right, q)||containsNode(root.right, q) && containsNode(root.right, p)){
			 return lowestCommonAncestor(root.right, p, q);
		 }
		 return null;  
    }
	/**
	 * 判断节点p是否在根为root的树中。
	 * @param root
	 * @param p
	 * @return
	 */
	 static boolean containsNode(TreeNode root, TreeNode p){
		 if(p == null )return false;
		 if(root == null) return false;
		 if(root.val == p.val ) return true;
		 boolean left = containsNode(root.left,p);
		 if(left) return true;
		 boolean right = containsNode(root.right, p);
		 return right;
	 }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeAlg.getTreeExample();
		TreeAlg.preOrder(root);
		TreeNode p = new TreeNode();
		p.val = 98;
		//System.out.println(containsNode(root,p));
		TreeNode q = new TreeNode();
		q.val = 98;
		System.out.println();
		System.out.println(lowestCommonAncestor(root,p,q).val);
//		LinkedList<TreeNode> reLinkedList = getReversePath(root, q);
//		System.out.println(q.val);
//		for(TreeNode temp:reLinkedList){
//			System.out.print(temp.val+" ");
//		}
		System.out.println(lowestCommonAncestor1(root,p,q).val);
	}

}
