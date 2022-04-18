package day2;

public class InnerClassDemo {
	public static void main(String[] args) {
		Pepsi pepsi=new Pepsi();
		pepsi.sellCola();
		
		Kalimark kali=new Kalimark();
		kali.sellCola();
	}
}

abstract class Cola{
	public abstract void makeCola();
	//public abstract void test();
}


class Pepsi{
	public void sellCola() {
		//Kalimark.CampaCola cola=new Kalimark().new CampaCola();//syntax to access non static inner class
		Kalimark.CampaCola cola=new Kalimark.CampaCola();//syntax to access static inner class
		cola.makeCola();
		System.out.println("fill the campa cola in pepsi bottle and sell....");
	}
}

class Kalimark{
	public void sellCola() {
		//CampaCola cola=new CampaCola();
		//cola.makeCola();
		//anonymius inner class - suitable only for one method abstract class - (functional abstract class)
		new Cola() {			
			@Override
			public void makeCola() {
				System.out.println("cola made.......");				
			}
		}.makeCola();
		System.out.println("fill the campa cola in bovonto bottle and sell....");
	}
	//all the properties of outer class is accessible by inner class
	static class CampaCola extends Cola{
		@Override
		public void makeCola() {
			System.out.println("cola made by campa cola....");
		}
	}

}