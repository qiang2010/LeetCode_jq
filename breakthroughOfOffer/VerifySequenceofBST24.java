package qiang.breakthroughOfOffer;

public class VerifySequenceofBST24 {

	
	boolean verify(int [] postOrder,int left, int right){
		
		if(postOrder == null) return true;
		if(left > right) return true;
		if(left == right ) return true;
		if(right -left ==1 || left- right ==1) return true;
		int root = postOrder[right];
		int i = left;
		for( i = left; i< right; i ++ ){
			if(postOrder[i] > root) break;
		}
		int j = i;
		while(j < right &&postOrder[j++]> root ){
		}
		if(j < right ) return false;
		boolean leftPart = verify(postOrder, left, i-1);
		if(!leftPart) return false;
		return verify(postOrder, i, right-1);
	}
	
	public static void main(String[] args) {
		
		int []postOrder = {5,7,6,9,11,10};
		
		System.out.println(new VerifySequenceofBST24().verify(postOrder, 0, postOrder.length-1));
	}

}
