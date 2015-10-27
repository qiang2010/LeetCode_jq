package qiang.tree;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree297 {

	public static void main(String[] args) {
		
		TreeNode root = TreeAlg.getTreeForSerialized("123#5");
		String k = new SerializeAndDeserializeBinaryTree297().serialize(root);
		System.out.println(k);
		root = new SerializeAndDeserializeBinaryTree297().deserialize(k);
		TreeAlg.preOrder(root);
		
	}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    
    	if(root == null) return "";
    	LinkedList<TreeNode > queue = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	
    	queue.add(root);
    	TreeNode top;
    	while(!queue.isEmpty()){
    		top = queue.getFirst();
    		queue.removeFirst();
    		if(top != null){
    			sb.append(top.val+",");
    			queue.addLast(top.left);
    			queue.addLast(top.right);
    		}
    		else{
    			sb.append("null,");
    		}
    	}
    	return sb.deleteCharAt(sb.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || "".equals(data))return null;
        String []splits = data.split(",");
        int i =0;
    	if("null".equals(splits[i]))return null;
    	TreeNode root = new TreeNode(Integer.parseInt(splits[i]));
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	queue.addLast(root);
    	TreeNode top,left,right;
    	while(i<splits.length && !queue.isEmpty()){
    		top = queue.getFirst();
    		queue.removeFirst();
    		left = right = null;
    		if(++i<splits.length){
    			if("null".equals(splits[i])==false){
    				left = new TreeNode(Integer.parseInt(splits[i]));
    			}
    		}
    		if(++i<splits.length){
    			if("null".equals(splits[i])==false){
    				right = new TreeNode(Integer.parseInt(splits[i]));
    			}
    		}
    		top.left = left;
    		top.right = right;
    		if(left !=null)queue.addLast(left);
    		if(right!=null)queue.addLast(right);
    	}
    	
    	return root;
    	
    }

}
