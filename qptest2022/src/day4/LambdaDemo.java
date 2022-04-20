package day4;

public class LambdaDemo {
	public static void main(String[] args) {
		//Traditional
		Doctor doctor=new MedicalCollege();
		doctor.doCure("somu",20000);
		
		//Better
		new Doctor() {			
			@Override
			public void doCure(String name,int amt) {
				System.out.println("anonymous logic for do cure...."+name+":"+amt);				
			}
		}.doCure("ramu",10000);
		
		//Lambda - best
		//Doctor doc=(String s,int a)->{System.out.println("lambda logic for do cure....");};
		Doctor doc=(s,a)->{System.out.println("lambda logic for do cure...."+s+":"+a);};
		doc.doCure("monu",3000);
		
		met(doc);
	}
	
	public static void met(Doctor doc) {
		doc.doCure("aaaa", 4343);
	}
}
//Lambdas work only with functional interfaces 
//Functional Interface - interface with only one method

@FunctionalInterface
interface Doctor{
	public void doCure(String name,int amount);
}

class MedicalCollege implements Doctor{
	@Override
	public void doCure(String name,int amount) {
		System.out.println("outer class logic for do cure..."+name+":"+amount);
	}
}