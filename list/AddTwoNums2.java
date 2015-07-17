
package qiang.list;

public class AddTwoNums2 {

	/**
	 * 
	 * You are given two linked lists representing two non-negative numbers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit.
	 *  Add the two numbers and return it as a linked list.
	 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 *  Output: 7 -> 0 -> 8
	 * 
	 * 
	 * 个位 －》 十位 －》 百位 
	 * 
	 * 一种方法就是： 遍历着两个链表，将其转化成数字，然后求和，将结果 在 转化成链表 （不通用，容易越界）
	 * 
	 * 方法二： 直接一遍遍历一遍求解。
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
    	if(l1 == null ) return l2;
    	if(l2 == null ) return l1;
    	ListNode head = new ListNode(-1);
    	if(l1 == null && l2 == null ) return head; 
    	 //1.  change listnode into int 
    	long num1 =changeListNodeToNum(l1), num2=changeListNodeToNum(l2);
    	System.out.println(num1 + " " + num2);
    	long re = num1 + num2;
    	if(re == 0) {
    		head.val = 0;
    		return head;
    	}
    	System.out.println(re);
    	head.val = (int)re%10;
    	re /= 10;
    	ListNode temp ;
    	ListNode next = head;
    	while(re!= 0){
    		temp = new ListNode((int)re%10);
    		next.next = temp;
    		next = temp;
    		re = re/10;
    	}
    	return head;
    	
    }
    private static long changeListNodeToNum(ListNode head){
    	if(head == null ) return 0;
    	long num = 0;
    	long base = 1;;
    	while(head != null){
    		num += base*head.val;
    		base *=10;
    		head = head.next;
    	}
    	return num;
    }
    
    /**
     *  一边遍历，一边求解
     * @param l1
     * @param l2
     * @return
     */
    public static  ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
     
    	if(l1 == null ) return l2;
    	if(l2 == null ) return l1;
    	ListNode head = new ListNode(-1);
    	ListNode temp,next = head;
    	
    	
    	int cur =  l1.val + l2.val;
    	int left = cur /10;
    	cur %= 10;
    	head.val = cur;
    	l1 = l1.next;
    	l2 = l2.next;
    	while(l1 != null && l2 != null ){
    		cur = l1.val + l2.val + left;
    		left = cur /10 ;
    		cur %= 10;
    		next.next = new ListNode(cur);
    		next = next.next;
    		l1 = l1.next;
    		l2 = l2.next; 
    	}
    	// 处理 l1 或 l2 剩下的
    	ListNode  leftList = null ;
    	if(l1 != null ) leftList = l1;
    	if(l2 != null ) leftList = l2;
    	if(leftList == null ){
    		if(left != 0 ){
    			next.next = new ListNode(left);
    		}
    		return head;
    	}
    	while(leftList != null){
    		cur = leftList.val  + left;
    		left = cur /10 ;
    		cur %= 10;
    		next.next = new ListNode(cur);
    		next = next.next;
    		leftList = leftList.next;
    	
    	}
		if(left != 0 ){
			next.next = new ListNode(left);
		}
    	return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] list1 = {9};
		int [] list2 = {1,9,9,9,9,9,9,9,9,9};
		ListNode l1 = ListNode.getListByNums(list1);
		ListNode l2 = ListNode.getListByNums(list2);
		ListNode.printList(l1);
		System.out.println();
		ListNode.printList(l2);
		System.out.println();
		ListNode.printList(addTwoNumbers2(l1,l2));
	}

}
