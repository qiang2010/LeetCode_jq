package qiang.test;

class TTT{
	TTT(int a){
		
	}
}

public class T7 extends TTT{

	T7(){
		super(2);
	}
	public static void main(String[] args) {
		
		
		
	}
	@Override
	protected T7 clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		 super.clone();
		 
		 return new T7();
	}
}
