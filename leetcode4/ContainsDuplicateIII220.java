package qiang.leetcode4;

public class ContainsDuplicateIII220 {
	public static void main(String[] args) {
		
		ContainsDuplicateIII220 dd = new ContainsDuplicateIII220();
		int []nums = {1,0,1,1};
		int k = 1; // 位置之差
		int t = 0;
		System.out.println(dd.containsNearbyAlmostDuplicate(nums, k, t));
	}
	    class BSTNode{
	        
	        long val;
	        BSTNode left,right;
	        BSTNode(long val){
	            this.val = val;            
	        }
	    }
	    
	    BSTNode addOne(BSTNode root,BSTNode tar){
	        if(root == null)return tar;
	        if(root.val < root.val){
	            root.right = addOne(root.right,tar);
	            return root;
	        }
	        root.left = addOne(root.left,tar);
	        return root;
	    }
	    BSTNode deleteOne(BSTNode root,BSTNode tar){
	        
	        if(root == null) return null;
	        
	        if(root == tar){
	            if(root.left == null && root.right == null) return null;
	            if(root.left != null && root.right ==null) {
	                return root.left;
	            }
	            if(root.left == null && root.right != null) return root.right;
	            // 左右都不为空
	            BSTNode p = root.right;
	            while(p.left!=null)p = p.left;
	            root.right = deleteOne(root.right,p);
	            p.left = root.left;
	            p.right = root.right;
	            return p;
	        }
	        if(root.val < tar.val){
	            root.right = deleteOne(root.right,tar);
	            return root;
	        }
	        root.left = deleteOne(root.left,tar);
	        return root;
	    }
	    boolean search(BSTNode root,long tar,int t){
	        
	        if(root == null) return false;
	        if(Math.abs(root.val - tar) <= t )return true;
	        if(root.val - tar > t){
	            return search(root.left,tar,t);
	        }
	        return search(root.right,tar,t);
	        
	    }
	    
	    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	        if(k < 1 || t < 0 || nums.length <2)return false;
	        int len = nums.length;
	        BSTNode  []map = new  BSTNode[len];
	        map[0] = new BSTNode(nums[0]);
	        BSTNode root = null;
	        root = addOne(root,map[0]);
	        for(int i = 1; i < len;i++){
	            if(search(root,nums[i],t))return true;
	            map[i] = new BSTNode(nums[i]);
	            if(i-k>-1){
	                root = deleteOne(root,map[i-k]);
	            }
	            root = addOne(root,map[i]); // 开始忘了root = 
	        }
	        return false;
	    }
	}
