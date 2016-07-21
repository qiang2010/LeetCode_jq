package qiang.tree;

public class CountUnivalueSubtrees250 {

	public static void main(String[] args) {
		CountUnivalueSubtrees250 cc = new CountUnivalueSubtrees250();
		TreeNode root = TreeAlg.getTreeForSerialized("51555#5");
		cc.postOrder(root);
		System.out.println(cc.count);
		StringBuilder sb = new StringBuilder();
	}
	
	class Node{
	     boolean flag ;
	     int val;
	     Node(boolean fl,int va){
	          flag = fl;
	           val = va;    
	     }
	}
	int count = 0;
	Node postOrder( TreeNode root){

	     if(root == null ) return null;
	     Node left = postOrder(root.left);
	     Node right = postOrder(root.right);
	     if(left ==null && right == null){ // 如果都是为null
	          count++;
	          return new Node(true,root.val);
	     }
	     if(left ==null){ // 如果左侧为空，就返回右侧和root的情况
	               boolean ff =(root.val == right.val)&& right.flag;
	               if( ff ) count++;
	               return new Node(ff, root.val);
	     }
	     if(right == null){
	          boolean ff = (root.val == left.val) && left.flag;
	          if(ff) count++;
	          return new Node(ff,root.val);
	     }
	     // 左右都不为null
	     boolean ff3 = (root.val == left.val) && (root.val == right.val) && left.flag && right.flag;
	     if(ff3) count++;
	     return new Node(ff3,root.val);
	}
}
