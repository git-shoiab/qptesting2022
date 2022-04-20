package day4;

public class GenericsDemo {
	public static void main(String[] args) {
		PaintBrush brush1=new PaintBrush();
		brush1.paint=new RedPaint();
//		brush1.paint=new Pastry();
		
		GoodPaintBrush brush2=new GoodPaintBrush();
		brush2.obj=new RedPaint();
		//brush2.obj=new Pastry();
		//Pastry pastry1=(Pastry)brush2.obj;
		
		if(brush2.obj instanceof Paint) {
			Paint paint=(Paint)brush2.obj;
			paint.doPaint();
		}
		else if(brush2.obj instanceof Pastry) {
			Pastry pastry=(Pastry)brush2.obj;
			pastry.doPastry();
		}
		
		RealGoodBrush<Pastry> rgb=new RealGoodBrush<>();
		rgb.obj=new Pastry();		
		Pastry past=rgb.obj;
		past.doPastry();
		
		RealGoodBrush<Water> rgb2=new RealGoodBrush<>();
		rgb2.obj=new Water();
		
	}
}


class PaintBrush{
	Paint paint;
}

class GoodPaintBrush{
	Object obj;
}

class RealGoodBrush<T>{
	T obj;
}

abstract class Paint{public abstract void doPaint();}
class RedPaint extends Paint{
	@Override
	public void doPaint() {
		System.out.println("red paint...");
	}
}

class Pastry{
	public void doPastry() {
		System.out.println("do pastry work...");
	}
}
class Water{
	public void doSprinkle() {System.out.println("water sprinkle");}
}
class DryAir{
	public void dusting() {System.out.println("do dusting...");}
}