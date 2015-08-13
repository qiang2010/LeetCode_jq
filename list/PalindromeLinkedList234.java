package qiang.list;

import java.lang.annotation.Target;

public class PalindromeLinkedList234 {

	
	   public  static boolean isPalindrome(ListNode head) {
	     
		   if(head == null) return true;
		   int size = 0;
		   ListNode tempHead = head;
		   while(tempHead!=null){
			   size++ ;
			   tempHead = tempHead.next;
		   }
		   tempHead = head;
		   int count = size /2 ;
		   while(count != 0 ){   // && tempHead != null
			   tempHead = tempHead.next;
			   count--;
		   }
		   tempHead = reverseList(tempHead);
		   count = size /2;
		   while(count!=0 && head.val == tempHead.val){
			   head = head.next;
			   tempHead = tempHead.next;
			   count-- ; 
		   }
		   if(count ==0) return true; 
		   return false;
	    }
	
	   /**
	    *  翻转链表，从一个链表上一个一个摘下来节点，放到一个新的链表的头部
	    * @param head
	    * @return
	    */
	   public static ListNode reverseList(ListNode head){
		   if(head ==null ) return null;
		   ListNode tempHead =head;
		   ListNode target  = head.next;
		   ListNode result = head;
		   head.next = null; //注意这里置空
		   while(target != null){
			   tempHead = target.next;
			   target.next = result;
			   result = target;
			   target = tempHead;
		   }
		   return result;
	   }
	   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.getAnExampleList();
		ListNode.printList(head);
		System.out.println();
//		ListNode.printList(reverseList(head));
		System.out.println(isPalindrome(head));
	}

}
