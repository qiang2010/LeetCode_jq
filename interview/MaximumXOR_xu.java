package qiang.interview;


import java.util.Scanner;

/**
 * algorithm for WAP test2
 * @author xpxstar@gmail.com
 * 2016-5-19
 */
public class MaximumXOR_xu {
	/** TrieNode to sign a bit.
	 * @author xpxstar@gmail.com
	 * 2016-5-19
	 */
	static class TrieNode {
	    TrieNode child0;
	    TrieNode child1;
	}
	/**
	 * TrieNode to sign the trace bits of nums.
	 * @author xpxstar@gmail.com
	 * 2016-5-19
	 */
	static class Trie {
	    TrieNode root = new TrieNode();
	    /**
	     * initial Trie with 0.
	     */
	    public Trie(){
	    	TrieNode p = root;
	    	for (int i = 41; i >0; i--) {
	    		p.child0 = new TrieNode();
	    		p = p.child0;
	        }
	    }
	    /**
	     * query the maxXor with n from trie tree.
	     * @param n
	     * @return
	     * @author xpxstar@gmail.com
	     * 2016-5-19
	     */
	    long query(long n){
	        TrieNode cur = root;
	        /*check if a bit of n is 1 or 0 from highest position 
	        	 * if it's 1 at the position,
	        	 * 	 check if there is a 0 at the same position from trie tree,
	        	 * 	 if that is true,the xor result with n at this position can be 1( 0^1 =1);
	        	 * 	 else the bit at this position has to be 0(1^1=0);
	        	 * else it's 0 at the position,
	        	 * 	 check if there is a 1 at the same position,the process is just as 1 situation. 
	        	 * through that we can get a max xOr with the given n
	        	 */
	        for (int i = 39; i > -1; i--) {
	        	if (((n >>> i) & 1) == 1) {
	            	if (cur.child0 != null) {
						cur = cur.child0;
					}else {
						n ^= (1l<<i);
						cur = cur.child1;
					}
	            } else {
	            	if (cur.child1!=null) {
						n ^= (1l<<i);
						cur = cur.child1;
					}else {
						cur = cur.child0;
					}
	            }
	        }
	        return n;
	    }
	    /**
	     * add a num to trie tree
	     * @param n
	     * @author xpxstar@gmail.com
	     * 2016-5-19
	     */
	    void add(long n){
	    	TrieNode cur = root;
	    	/*
	    	 * add a num to trie tree by it's bit trace.
	    	 */
	    	for (int i = 39; i > -1; i--) {
	            if (((n >>> i) & 1) == 1) {
	                if (cur.child1 == null) {
	                    cur.child1 = new TrieNode();
	                }
	                cur = cur.child1;
	            } else {
	                if (cur.child0 == null) {
	                    cur.child0 = new TrieNode();
	                }
	                cur = cur.child0;
	            }
	        }
	    }
	}
	
	public static void main(String[] args){
		  Scanner in = new Scanner(System.in);
		  int N = in.nextInt();
		  if (N < 1) {System.out.println(0);return;}
		  long[] nums = new long[N];
		  int count = 0;
		  Trie trie = new Trie();
	      long curxor = 0;
	      long max = 0;
	      /*
	       * build trie tree while input source nums
	       * trie tree store the prefix of nums. 
	       */
		  while( count < N){
			  nums[count] = in.nextLong();
			  curxor ^= nums[count];
			  trie.add(curxor);
			  max = Math.max(max, curxor);
			  count++;
		  }
		  
		  System.out.println(new MaximumXORWithPrefixAndSuffix().maximumXorWithPrefixAndSuffix(nums));
		  curxor = 0;
		  /*
		   * match the suffix with prefix in trie tree. 
		   * find the max xor result
		   */
		  for (int i = N-1; i >-1; i--) {
			  curxor ^= nums[i];
	          max = Math.max(max, trie.query(curxor));
		  }
		  System.out.println(max);
	}
	public static long xu(long []nums){
		  int count = 0;
		  int N = nums.length;
		  Trie trie = new Trie();
	      long curxor = 0;
	      long max = 0;
		  while( count < N){
			  curxor ^= nums[count];
			  trie.add(curxor);
			  max = Math.max(max, curxor);
			  count++;
		  }
		  
		  curxor = 0;
		  /*
		   * match the suffix with prefix in trie tree. 
		   * find the max xor result
		   */
		  for (int i = N-1; i >-1; i--) {
			  curxor ^= nums[i];
	          max = Math.max(max, trie.query(curxor));
		  }
//		  System.out.println(max);
		  return max;
	}
}
/*
 * the space complex is O(n)
 * with the time complex is O(n) (each add and query action cost 40 times which is a const)
 */
	
