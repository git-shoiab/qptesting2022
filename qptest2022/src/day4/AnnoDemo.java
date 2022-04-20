package day4;

import java.lang.reflect.Field;

public class AnnoDemo {
	public static void main(String[] args) {
		AnnoTest at=Container.getAnnoTestObj();
		System.out.println(at.value);
	}
}

class Container{
	public static AnnoTest getAnnoTestObj() {
		AnnoTest obj=new AnnoTest();
		try {
		Class c=obj.getClass();
		Field field=c.getDeclaredField("value");
		field.setAccessible(true);
		In in=field.getAnnotation(In.class);
		if(in!=null) {
			String v=in.name();
			obj.value=v;
		}
		}catch(Exception e) {}
		return obj;
	}
}

class AnnoTest{
	@In(name="hello")
	String value;
}