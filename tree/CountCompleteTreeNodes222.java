package qiang.tree;

public class CountCompleteTreeNodes222 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countFullBinaryTreeNodesNum(0));
		String pre = "124536";//"12";
		String mid = "425163";//"21";
		TreeNode root = TreeAlg.buildTree(pre, 0, pre.length()-1, mid, 0, mid.length()-1);
		TreeAlg.preOrder(root);
		System.out.println("pre");
		System.out.println(countNodes(root));
	}
	/**
	 *  计算完全二叉树的节点数目
	 *  1. 方法一，层次遍历，这样时间复杂度是 O（N），但是这中方法是超时
	 *  2. 如果是满二叉树，那么知道树的深度，根据 2^(N+1) - 1，就是节点个数
	 *     完全二叉树，只有最后一层是不满的，这样我们就可以利用满二叉树的性质求解
	 *     从根一直往左找，找到最后，就是该完全二叉树的深度，对右子树做同样操作，可以得到右子树深度，如果不同，表示左子树的部分
	 *     仍然不是满二叉树，但是右子树已经是满二叉树了，循环找下去，直到叶子 
	 * @param root
	 * @return
	 */
    public static int countNodes(TreeNode root) {
    	if(root == null)  return 0;
    	int sum = 0;
    	int leftD;
    	int rightD;
        while(true){ 
        	leftD = getDepth(root.left);
            rightD = getDepth(root.right);
            System.out.println(leftD + " " + rightD);
            if(leftD == -1){
            	sum+=1;
            	break;
            }
        	if(rightD == -1){
        		sum +=2;
        		break;
        	}
		     // 左右深度相同，那么继续处理右子树，左子树是满二叉树
		     if(leftD == rightD){
		    	 if(leftD == 0 ) break;
		     	sum = sum + 1+ countFullBinaryTreeNodesNum(leftD);
		     	root = root.right;
		     }else{
		        // 不同，那么右子树为满二叉树，继续处理左子树
		        sum = sum +1 + countFullBinaryTreeNodesNum(rightD);
		        root = root.left;
		        //if(root == null ) break;
		    } 
		     
		}
    	return sum;
    }
    private static int getDepth(TreeNode root){
    	if(root == null) return -1; 
    	if(root.left == null) return 0;
    	int count = 0;
    	TreeNode temp = root.left;
    	while(temp!=null){
    		count++;
    		temp = temp.left;
    	}
    	System.out.println("count " +count);
    	return count;
    }
    private static int countFullBinaryTreeNodesNum(int depth){
    	if(depth == -1) return 0;
    	return  (2<<(depth))  - 1;
    }
}
