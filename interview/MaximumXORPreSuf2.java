package qiang.interview;
/**
 * 给定一个数字，返回最大异或前后缀子串
 * 也就是给定数组a，返回 数组中前缀和后缀的XOR最大值。
 * @author jq
 *
 */
public class MaximumXORPreSuf2 {
	public static void main(String[] args) {
		MaximumXORPreSuf2 dd = new MaximumXORPreSuf2();
		MaximumXORPreSuf dd2 = new MaximumXORPreSuf();
		
		int []  nums = {4,5,6,23,44,100000};
		System.out.println(dd.maxXORSubarray(nums));
		System.out.println(dd.validataion(nums));
		System.out.println(dd2.maxXORSubarray(nums));
	}
	int maxXORSubarray(int []nums){
		if(nums == null || nums.length == 0) return 0;
		int xor = 0;
		for(int i = 0 ; i < nums.length;i++){
			xor = xor^nums[i];
		}
		int lxor = 0; // left part xor
		int rxor = xor; // right part xor
		int tempAns;
		insertNum(0);
		int ans = 0;
		for(int i = 0;i<nums.length;i++ ){
			lxor = lxor ^ nums[i];
			rxor = rxor ^ nums[i];
			insertNum(lxor);
			tempAns = findMaxXOR(rxor);
			if(tempAns > ans) ans = tempAns;
		}
		return ans;
	}
	class TrieNode{
		int value;
		TrieNode left ,right;
		TrieNode(){
			left = right = null;
			value = -1;
		}
	}
	TrieNode root = null;
	void insertNum(int num){
		if(root == null) root = new TrieNode();
		TrieNode cur = root;
		int te = num;
		for(int i = 31;i>-1;i--){
			boolean dir = (num &(1<<i))==0 ;
			// 0 向左走，1向右走
			if(dir){
				if(cur.left == null) cur.left = new TrieNode();
				cur = cur.left;
			}else{
				if(cur.right == null) cur.right = new TrieNode();
				cur = cur.right;
			}
		}
		cur.value = te;
	}
	int findMaxXOR(int curXor){
		TrieNode cur = root;
		// 查找的时候，1 向左走，0向右走
		int tt = curXor;
		for(int i = 31;i>-1;i--){
			boolean dir = (tt &(1<<i)) != 0 ;
			// 1 向左走，0向右走
			if(dir){
				if(cur.left != null)
					cur = cur.left;
				else cur = cur.right;
			}else{
				if(cur.right != null)
					cur = cur.right;
				else cur = cur.left;
			}
		}
		return cur.value ^ curXor;
	}
	// 用于验证， 时间复杂度是 O(N^2)
	int validataion(int []nums){
		if(nums == null || nums.length ==0) return 0;
		int size = nums.length;
		int bdp[] = new int[size];
		int ldp[] = new int[size];
		int ans = nums[0];
		bdp[0] = nums[0];
		ldp[size-1] = nums[size-1];
		for(int i = 1 ; i < size;i++){
			bdp[i] = bdp[i-1] ^ nums[i];
			if(bdp[i] > ans) ans = bdp[i];
		}
		if(ldp[size-1]> ans) ans = ldp[size-1];
		for(int j = size-2;j>-1;j--){
			ldp[j] = ldp[j+1] ^ nums[j];
			if(ldp[j]> ans) ans = ldp[j];
		}
		
		// for for
		int tempAns;
		for(int i = 0;i<size-1;i++)
			for(int j = i+1;j<size;j++){
				tempAns = bdp[i] ^ ldp[j];
				if(tempAns > ans) ans = tempAns;
			}
		return ans;
	}
	
}
