package day2;

public class InterfaceDemo {

}


interface Doctor{
	public void doCure();
	public static final float pi=3.14f;
	
	static void meeet() {
		System.out.println("meeet static method called...");
	}
	default void met() {//template method
		System.out.println("default met called...");
		met2();
	}
	
	private void met2() {//secret methods
		System.out.println("private method called...");
	}
}

class MedicalCollege implements Doctor{
	
	@Override
	public void doCure() {
		System.out.println("do cure implemented as per alopathy medicine...");
	}
}

class AyurvedMedicalCollege implements Doctor{
	
	@Override
	public void doCure() {
		System.out.println("do cure implemented as per ayurved medicine...");
	}
}