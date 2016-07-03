package qiang.interview;


import java.util.Scanner;

/**
 * Question:
 * We have N numbers as an array, 
 * you need to find a prefix array and a suffix array,
 * which we can get the maximum xor value with all elements in them. 
 * Notice that for prefix[0, l] and suffix[r, n - 1], 
 * do not intersect (l < r), and they can be empty.
 * Solution: Trie Tree 
 *   Time  Complexity: O(N)
 *   Space Complexity: O(N)
 * @author jq
 *
 */
public class Main{
    public static void main(String[] args) {
       // TODO: Implement your program
       Main main = new Main();
       System.out.println(main.maximumXorWithPrefixAndSuffix());
    }
    
    public long maximumXorWithPrefixAndSuffix(){
		// input 
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		if(size == 0) {
			in.close();
			return 0L;
		}
		long [] nums = new long[size];
		for(int i = 0 ; i < size; i ++){
			nums[i] = in.nextLong();
		}
		in.close();
		
//		System.out.println(this.validataion(nums)); 
		return this.maximumXorWithPrefixAndSuffix(nums);
	}
	
	/**
	 * time complex: O(N), N is array size 
	 * @param nums
	 * @return
	 */
	public long maximumXorWithPrefixAndSuffix(long []nums){
		if(nums == null || nums.length == 0) return 0; // for test
		long xor = 0;
		for(int i = 0 ; i < nums.length;i++){
			xor = xor^nums[i];
		}
		long lxor = 0; // left part xor 
		long rxor = xor; // right part xor 
		long tempAns;
		this.root = new TrieNode(); // new tree every time 
		insertNum(0);
		long ans = 0;
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
		long value;
		TrieNode left ,right;
		TrieNode(){
			left = right = null;
			value = -1;
		}
	}
	TrieNode root = null;
	final int LONG_BIT_NUM = 39; // (1L << 40) > 1e12 
	void insertNum(long num){
		if(root == null) root = new TrieNode();
		TrieNode cur = root;
		for(int i = LONG_BIT_NUM;i>-1;i--){
			boolean dir = (num &(1L<<i))==0 ;
			// 0  turn left ;if not, turn right
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
	long findMaxXOR(long curXor){
		TrieNode cur = root;
		// search, 0 turn right, if not turn left, opposite to insert operation
		for(int i = LONG_BIT_NUM;i>-1;i--){
			boolean dir = (curXor &(1L<<i)) != 0 ;
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
	/** 
	 * used for validation， time complex:O(N^2)
	 */
	public long validataion(long []nums){
		if(nums == null ||nums.length ==0) return 0;
		int size = nums.length;
		long bdp[] = new long[size];
		long ldp[] = new long[size];
		long ans = nums[0];
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
		long tempAns;
		for(int i = 0;i<size-1;i++)
			for(int j = i+1;j<size;j++){
				tempAns = bdp[i] ^ ldp[j];
				if(tempAns > ans) ans = tempAns;
			}
		return ans;
	}
}