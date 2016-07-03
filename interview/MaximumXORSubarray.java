package qiang.interview;
/**
 * 给定一个数字，返回最大异或子串
 * 也就是给定数组a，返回 数组中某个连续子串，其异或最大。
 * @author jq
 *
 */
public class MaximumXORSubarray {
	public static void main(String[] args) {
		MaximumXORSubarray dd = new MaximumXORSubarray();
		int []  nums = {8, 1, 2, 12, 7, 6};
		System.out.println(dd.maxXORSubarray(nums));
		
	}
	int maxXORSubarray(int []nums){
		if(nums == null || nums.length == 0) return 0;
		int xor = 0;
		int ans = -1;
		insertNum(0);
		int curM;
		for(int i = 0 ; i < nums.length;i++){
			xor = xor^nums[i];
			insertNum(xor);
			curM = findMaxXOR(xor);
			if(curM > ans) ans = curM;
		}
		return ans;
	}
	class TrieNode{
		int value;
		TrieNode left ,right;
		TrieNode(){
			left = right = null;
			value = 0;
		}
	}
	TrieNode root = null;
	void insertNum(int num){
		if(root == null) root = new TrieNode();
		TrieNode cur = root;
		for(int i = 31;i>-1;i--){
			boolean dir = ((num &(1<<i))==0 );
			// 0 向左走，1向右走
			if(dir){
				if(cur.left == null) cur.left = new TrieNode();
				cur = cur.left;
			}else{
				if(cur.right == null) cur.right = new TrieNode();
				cur = cur.right;
			}
		}
		cur.value = num;
	}
	int findMaxXOR(int curXor){
		TrieNode cur = root;
		// 查找的时候，1 向左走，0向右走
		int tt = curXor;
		for(int i = 31;i>-1;i--){
			boolean dir = ((tt &(1<<i)) != 0 );
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
}
