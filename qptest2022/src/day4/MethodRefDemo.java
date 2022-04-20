package day4;

public class MethodRefDemo {
	public MethodRefDemo() {
		System.out.println("constructor logic - I can have teach logic...");
	}
	public static void main(String[] args) {
		Teacher t=MethodRefDemo::myTeaching;		
		t.teach();
		
		t=new MethodRefDemo()::myTeaching2;
		t.teach();
		
		t=MethodRefDemo::new;
		t.teach();
	}
	
	public static void myTeaching() {
		System.out.println("my teaching called...");
	}
	
	public void myTeaching2() {
		System.out.println("my teaching non static called..");
	}
}

interface Teacher{
	public void teach();
}
