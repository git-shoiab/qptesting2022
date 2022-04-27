package day6;

public class PerformanceDemo1 {
	public static void main(String[] args) {
		Business bu1=Business.createBusiness();//new Business();
		bu1.i=20;
		Business bu2=Business.createBusiness();//new Business();
		bu2.i=40;
		
		System.out.println(bu1.i);
		System.out.println(bu2.i);
	}
}

class Business implements Cloneable{
	int i=0;
	private Business() {
		System.out.println("business object created...");
	}
	private static Business business;
	public static Business createBusiness() {
		if(business==null) {
			business=new Business();
			return business;
		}
		else {
			return business.getClone();
		}
	}
	private Business getClone() {
		try {
			return (Business)super.clone();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}