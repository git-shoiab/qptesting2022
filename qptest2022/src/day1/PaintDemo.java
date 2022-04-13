package day1;

public class PaintDemo {
	public static void main(String[] args) {
		BadPaintBrush bp=new BadPaintBrush();
		bp.doPaint(1);
		
		GoodPaintBrush gpb=new GoodPaintBrush();
		gpb.paint=new GreenPaint();
		gpb.doPaint();
	}
}

class BadPaintBrush {
	public void doPaint(int i) {
		if(i==1) {
			System.out.println("red...");
		}
		else if(i==2) {
			System.out.println("blue....");
		}
	}
}
//the above code is open for modification so it is a bad code.

class GoodPaintBrush{
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}

/*
 *  1. Convert the condition to classes.
	2. Group them under a hierarchy
	3. Create a association between the using class and the heirarchial class
*/
class Paint{
	
}
class BluePaint extends Paint{
	
}
class GreenPaint extends Paint{
	
}