package qiang.list;

public class ListNode {

     public int val;
     public  ListNode next = null;
     public ListNode(int x) { val = x; }
     
     public static ListNode getAExampleList(){
    	 ListNode head = new ListNode(0) ;
    	 ListNode tempNode = head ,next;
    	 int []ll = {1,4,4,5,2,8,9,0};
    	 for(int i =0; i< ll.length; i++){
    		 next = new ListNode(ll[i]);
    		 tempNode.next = next;
    		 tempNode = next;
    	 }
    	 
    	 return head;
     }
     
     public static ListNode getListByNums(int[] nums){
    	 int size = nums.length;
    	 if(nums == null  || size == 0) return new ListNode(-1);
    	 ListNode head = new ListNode(nums[0]);
    	 ListNode temp,next = head;
    	 for(int i = 1; i < size ; i++){
    		 temp = new ListNode(nums[i]);
    		 next.next = temp;
    		 next = temp;
    	 }
    	 return head;
     }
     
     public static void printList(ListNode head){
    	 while(head!=null){
    		 System.out.print(head.val + "  ");
    		 head = head.next;
    	 }
     }
}
